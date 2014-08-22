/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2014 Briac Pilpre, Aaron Madlon-Kay
               Home page: http://www.omegat.org/
               Support center: http://groups.yahoo.com/group/OmegaT/

 This file is part of OmegaT.

 OmegaT is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 OmegaT is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **************************************************************************/

package org.omegat.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JMenuItem;

import org.omegat.core.Core;
import org.omegat.core.CoreEvents;
import org.omegat.core.data.ProjectFactory;
import org.omegat.core.events.IProjectEventListener;
import org.omegat.gui.main.IMainWindow;
import org.omegat.gui.main.ProjectUICommands;

/**
 * Management of recent projects
 * 
 * @author Briac Pilpre
 * @author Aaron Madlon-Kay
 */
public class RecentProjects implements Iterable<String> {
    private final ArrayList<String> recentProjects = new ArrayList<String>();
    private final int mostRecentProjectSize;
    private final JMenuItem projectOpenRecentMenuItem;

    public RecentProjects(JMenuItem projectOpenRecentMenuItem) {
        if (projectOpenRecentMenuItem == null) {
            IMainWindow mainWindow = Core.getMainWindow();
            if (mainWindow == null) {
                throw new IllegalArgumentException(
                        "Cannot initialize Recent Menu Items without a Main Window");
            }
            projectOpenRecentMenuItem = mainWindow.getMainMenu().getProjectRecentMenuItem();
        }

        this.mostRecentProjectSize = Preferences.getPreferenceDefault(Preferences.MOST_RECENT_PROJECTS_SIZE, 5);
        this.projectOpenRecentMenuItem = projectOpenRecentMenuItem;
        loadFromPrefs();
    }

    public RecentProjects() {
        this(null);
    }

    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableCollection(recentProjects).iterator();
    }

    public void saveToPrefs() {
        for (int i = 0; i < mostRecentProjectSize; i++) {
            if (i + 1 > recentProjects.size()) {
                break;
            }
            Preferences.setPreference(Preferences.MOST_RECENT_PROJECTS_PREFIX
                    + i, recentProjects.get(i));
        }

        Preferences.save();
    }

    public final void loadFromPrefs() {
        for (int i = 0; i < mostRecentProjectSize; i++) {
            String projectKey = Preferences.MOST_RECENT_PROJECTS_PREFIX + i;

            if (!Preferences.existsPreference(projectKey)) {
                break;
            }

            add(Preferences.getPreference(projectKey));
        }
    }

    public void updateMenu() {
        if (projectOpenRecentMenuItem == null && Core.getMainWindow() == null) {
            return;
        }

        JMenuItem recentMenu = projectOpenRecentMenuItem;

        recentMenu.removeAll();

        Iterator<String> it = recentProjects.iterator();
        while (it.hasNext()) {
            final String recentProject = it.next();

            JMenuItem recentProjectMenuItem = new JMenuItem(recentProject);
            recentProjectMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (Core.getProject().isProjectLoaded()) {
                        CoreEvents.registerProjectChangeListener(new IProjectEventListener() {
                            @Override
                            public void onProjectChanged(PROJECT_CHANGE_TYPE eventType) {
                                if (eventType == PROJECT_CHANGE_TYPE.CLOSE) {
                                    ProjectUICommands.projectOpen(new File(recentProject));
                                    CoreEvents.unregisterProjectChangeListener(this);
                                }
                            }
                        });
                        ProjectUICommands.projectClose();
                    } else {
                        ProjectUICommands.projectOpen(new File(recentProject));
                    }
                }
            });

            recentMenu.add(recentProjectMenuItem);
        }

    }

    public void add(String element) {
        recentProjects.remove(element);
        recentProjects.add(0, element);

        // Shrink the list to match the desired size.
        while (recentProjects.size() > mostRecentProjectSize) {
            recentProjects.remove(mostRecentProjectSize);
        }
    }

}
