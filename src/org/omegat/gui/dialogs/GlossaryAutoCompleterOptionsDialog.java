/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool 
          with fuzzy matching, translation memory, keyword search, 
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2013 Zoltan Bartko
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

package org.omegat.gui.dialogs;

import java.awt.Frame;
import org.omegat.util.OStrings;
import org.omegat.util.Preferences;
import org.omegat.util.gui.StaticUIUtils;

/**
 *
 * @author bartkoz
 */
public class GlossaryAutoCompleterOptionsDialog extends javax.swing.JDialog {
    
    /**
     * Creates new form GlossaryAutoCompleterOptionsDialog
     */
    public GlossaryAutoCompleterOptionsDialog(Frame parent) {
        super(parent, true);
        
        StaticUIUtils.setEscapeClosable(this);
        
        initComponents();
        
        getRootPane().setDefaultButton(okButton);
        
        // initializing options
        displaySourceCheckBox.setSelected(Preferences.isPreference(Preferences.AC_GLOSSARY_SHOW_SOURCE));
        activateSourceItems(displaySourceCheckBox.isSelected());
        sourceFirstRadioButton.setSelected(!Preferences.isPreference(Preferences.AC_GLOSSARY_SHOW_TARGET_BEFORE_SOURCE));
        targetFirstRadioButton.setSelected(Preferences.isPreference(Preferences.AC_GLOSSARY_SHOW_TARGET_BEFORE_SOURCE));
        sortBySourceCheckBox.setSelected(Preferences.isPreference(Preferences.AC_GLOSSARY_SORT_BY_SOURCE));
        longerFirstCheckBox.setSelected(Preferences.isPreference(Preferences.AC_GLOSSARY_SORT_BY_LENGTH));
        sortEntriesCheckBox.setSelected(Preferences.isPreference(Preferences.AC_GLOSSARY_SORT_ALPHABETICALLY));
        followCapitalizationCheckBox.setSelected(Preferences.isPreference(Preferences.AC_GLOSSARY_CAPITALIZE));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceButtonGroup = new javax.swing.ButtonGroup();
        displaySourceCheckBox = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        sourceFirstRadioButton = new javax.swing.JRadioButton();
        targetFirstRadioButton = new javax.swing.JRadioButton();
        sortBySourceCheckBox = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        longerFirstCheckBox = new javax.swing.JCheckBox();
        sortEntriesCheckBox = new javax.swing.JCheckBox();
        followCapitalizationCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(OStrings.getString("AC_OPTIONS_GLOSSARY_FRAME")); // NOI18N

        displaySourceCheckBox.setText(OStrings.getString("AC_OPTIONS_DISPLAY_SOURCE")); // NOI18N
        displaySourceCheckBox.setToolTipText(OStrings.getString("AC_OPTIONS_DISPLAY_SOURCE_TOOLTIP")); // NOI18N
        displaySourceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displaySourceCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        sourceButtonGroup.add(sourceFirstRadioButton);
        sourceFirstRadioButton.setText(OStrings.getString("AC_OPTIONS_SOURCE_FIRST")); // NOI18N
        sourceFirstRadioButton.setToolTipText(OStrings.getString("AC_OPTIONS_SOURCE_FIRST")); // NOI18N

        sourceButtonGroup.add(targetFirstRadioButton);
        targetFirstRadioButton.setText(OStrings.getString("AC_OPTIONS_TARGET_FIRST")); // NOI18N
        targetFirstRadioButton.setToolTipText(OStrings.getString("AC_OPTIONS_TARGET_FIRST_TOOLTIP")); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/omegat/Bundle"); // NOI18N
        sortBySourceCheckBox.setText(bundle.getString("AC_OPTIONS_SORT_SOURCE_ALPHABETICALLY")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(OStrings.getString("AC_GLOSSARY_TARGET_PANEL"))); // NOI18N

        longerFirstCheckBox.setText(OStrings.getString("AC_OPTIONS_SORT_BY_LENGTH")); // NOI18N
        longerFirstCheckBox.setToolTipText(OStrings.getString("AC_OPTIONS_SORT_BY_LENGTH_TOOLTIP")); // NOI18N

        sortEntriesCheckBox.setText(OStrings.getString("AC_OPTIONS_SORT_TARGET_ALPHABETICALLY")); // NOI18N
        sortEntriesCheckBox.setToolTipText(OStrings.getString("AC_OPTIONS_SORT_ALPHABETICALLY_TOOLTIP")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(longerFirstCheckBox)
                    .addComponent(sortEntriesCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(longerFirstCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sortEntriesCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        followCapitalizationCheckBox.setText(OStrings.getString("AC_GLOSSARY_CAPITALIZE")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addGap(4, 4, 4)
                        .addComponent(cancelButton))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displaySourceCheckBox)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sortBySourceCheckBox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(sourceFirstRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(targetFirstRadioButton))))
                            .addComponent(followCapitalizationCheckBox))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displaySourceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceFirstRadioButton)
                    .addComponent(targetFirstRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sortBySourceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(followCapitalizationCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doClose() {
        setVisible(false);
        dispose();
    }
     
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void activateSourceItems(boolean activate) {
        sortBySourceCheckBox.setEnabled(activate);
        sourceFirstRadioButton.setEnabled(activate);
        targetFirstRadioButton.setEnabled(activate);
    }
    
    private void displaySourceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displaySourceCheckBoxActionPerformed
        activateSourceItems(displaySourceCheckBox.isSelected());
    }//GEN-LAST:event_displaySourceCheckBoxActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        Preferences.setPreference(Preferences.AC_GLOSSARY_SHOW_SOURCE, displaySourceCheckBox.isSelected());
        if (displaySourceCheckBox.isSelected()) {
            Preferences.setPreference(Preferences.AC_GLOSSARY_SHOW_TARGET_BEFORE_SOURCE, targetFirstRadioButton.isSelected());
            Preferences.setPreference(Preferences.AC_GLOSSARY_SORT_BY_SOURCE, sortBySourceCheckBox.isSelected());
        }
        Preferences.setPreference(Preferences.AC_GLOSSARY_SORT_BY_LENGTH, longerFirstCheckBox.isSelected());
        Preferences.setPreference(Preferences.AC_GLOSSARY_SORT_ALPHABETICALLY, sortEntriesCheckBox.isSelected());
        Preferences.setPreference(Preferences.AC_GLOSSARY_CAPITALIZE, followCapitalizationCheckBox.isSelected());
        doClose();
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox displaySourceCheckBox;
    private javax.swing.JCheckBox followCapitalizationCheckBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox longerFirstCheckBox;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox sortBySourceCheckBox;
    private javax.swing.JCheckBox sortEntriesCheckBox;
    private javax.swing.ButtonGroup sourceButtonGroup;
    private javax.swing.JRadioButton sourceFirstRadioButton;
    private javax.swing.JRadioButton targetFirstRadioButton;
    // End of variables declaration//GEN-END:variables
}
