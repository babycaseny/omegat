/**************************************************************************
 OmegaT - Computer Assisted Translation (CAT) tool
          with fuzzy matching, translation memory, keyword search,
          glossaries, and translation leveraging into updated projects.

 Copyright (C) 2000-2006 Keith Godfrey and Maxym Mykhalchuk
               2007-2008 Didier Briel, Martin Fleurke
               2009 Didier Briel
               2012 Martin Fleurke, Didier Briel
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

package org.omegat.filters2.html2;

import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.AbstractAction;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omegat.util.OStrings;
import org.omegat.util.gui.StaticUIUtils;

/**
 * Modal dialog to edit (X)HTML filter options.
 * 
 * @author Maxym Mykhalchuk
 * @author Didier Briel
 * @author Martin Fleurke
 */
@SuppressWarnings("serial")
public class EditOptionsDialog extends javax.swing.JDialog {
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    /** Creates new form EditOptionsDialog */
    public EditOptionsDialog(java.awt.Dialog parent, Map<String, String> config) {
        super(parent, true);
        initComponents();

        options = new HTMLOptions(new TreeMap<String, String>(config));

        switch (options.getRewriteEncoding()) {
        case ALWAYS:
            alwaysRB.setSelected(true);
            break;
        case IFHEADER:
            ifHasHeaderRB.setSelected(true);
            break;
        case IFMETA:
            ifHasMetaRB.setSelected(true);
            break;
        case NEVER:
            neverRB.setSelected(true);
            break;
        }
        translateHrefCB.setSelected(options.getTranslateHref());
        translateSrcCB.setSelected(options.getTranslateSrc());
        translateLangCB.setSelected(options.getTranslateLang());
        translateHreflangCB.setSelected(options.getTranslateHreflang());
        translateValueCB.setSelected(options.getTranslateValue());
        translateButtonValueCB.setSelected(options.getTranslateButtonValue());
        paragraphOnBrCB.setSelected(options.getParagraphOnBr());
        skipRegExpTF.setText(options.getSkipRegExp());
        skipMetaTF.setText(options.getSkipMeta());
        ignoreTagsTF.setText(options.getIgnoreTags());
        removeCommentsCB.setSelected(options.getRemoveComments());
        compressWhitespaceCB.setSelected(options.getCompressWhitespace());

        StaticUIUtils.setEscapeAction(this, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    private HTMLOptions options;

    public HTMLOptions getOptions() {
        return options;
    }

    private int returnStatus = RET_CANCEL;

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        alwaysRB = new javax.swing.JRadioButton();
        ifHasHeaderRB = new javax.swing.JRadioButton();
        ifHasMetaRB = new javax.swing.JRadioButton();
        neverRB = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        translateHrefCB = new javax.swing.JCheckBox();
        translateSrcCB = new javax.swing.JCheckBox();
        translateLangCB = new javax.swing.JCheckBox();
        translateHreflangCB = new javax.swing.JCheckBox();
        translateValueCB = new javax.swing.JCheckBox();
        translateButtonValueCB = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        paragraphOnBrCB = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        skipRegExpTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        skipMetaTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ignoreTagsTF = new javax.swing.JTextField();
        compressWhitespaceCB = new javax.swing.JCheckBox();
        removeCommentsCB = new javax.swing.JCheckBox();

        setTitle(OStrings.getString("HTML_Filter_Options")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        org.openide.awt.Mnemonics.setLocalizedText(okButton, OStrings.getString("BUTTON_OK")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(okButton);

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, OStrings.getString("BUTTON_CANCEL")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, OStrings.getString("HTML_OPTION_REWRITE_ENC")); // NOI18N
        jPanel1.add(jLabel1);

        buttonGroup1.add(alwaysRB);
        org.openide.awt.Mnemonics.setLocalizedText(alwaysRB, OStrings.getString("HTML_REWRITE_ENC_ALWAYS")); // NOI18N
        jPanel1.add(alwaysRB);

        buttonGroup1.add(ifHasHeaderRB);
        ifHasHeaderRB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(ifHasHeaderRB, OStrings.getString("HTML_REWRITE_ENC_IF_HAS_HEADER")); // NOI18N
        jPanel1.add(ifHasHeaderRB);

        buttonGroup1.add(ifHasMetaRB);
        org.openide.awt.Mnemonics.setLocalizedText(ifHasMetaRB, OStrings.getString("HTML_REWRITE_ENC_IF_HAS_META")); // NOI18N
        jPanel1.add(ifHasMetaRB);

        buttonGroup1.add(neverRB);
        org.openide.awt.Mnemonics.setLocalizedText(neverRB, OStrings.getString("HTML_REWRITE_ENC_NEVER")); // NOI18N
        jPanel1.add(neverRB);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, OStrings.getString("HTML_TRANSLATE_ATTRIBUTES")); // NOI18N
        jPanel1.add(jLabel2);

        translateHrefCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateHrefCB, OStrings.getString("HTML_TRANSLATE_HREF")); // NOI18N
        jPanel1.add(translateHrefCB);

        translateSrcCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateSrcCB, OStrings.getString("HTML_TRANSLATE_SRC")); // NOI18N
        jPanel1.add(translateSrcCB);

        translateLangCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateLangCB, OStrings.getString("HTML_TRANSLATE_LANG")); // NOI18N
        jPanel1.add(translateLangCB);

        translateHreflangCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateHreflangCB, OStrings.getString("HTML_TRANSLATE_HREFLANG")); // NOI18N
        jPanel1.add(translateHreflangCB);

        translateValueCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateValueCB, OStrings.getString("HTML_TRANSLATE_VALUE")); // NOI18N
        jPanel1.add(translateValueCB);

        translateButtonValueCB.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(translateButtonValueCB, OStrings.getString("HTML_TRANSLATE_BUTTON_VALUE")); // NOI18N
        jPanel1.add(translateButtonValueCB);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, OStrings.getString("HTML_PARAGRAPH_ON")); // NOI18N
        jPanel1.add(jLabel3);

        org.openide.awt.Mnemonics.setLocalizedText(paragraphOnBrCB, OStrings.getString("HTML_PARAGRAPH_ON_BR")); // NOI18N
        jPanel1.add(paragraphOnBrCB);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, OStrings.getString("HTML_SKIPREGEXP")); // NOI18N
        jPanel1.add(jLabel4);
        jPanel1.add(skipRegExpTF);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, OStrings.getString("HTML_SKIPMETA")); // NOI18N
        jPanel1.add(jLabel5);
        jPanel1.add(skipMetaTF);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, OStrings.getString("HTML_IGNORE_TAGS")); // NOI18N
        jPanel1.add(jLabel6);
        jPanel1.add(ignoreTagsTF);

        org.openide.awt.Mnemonics.setLocalizedText(compressWhitespaceCB, OStrings.getString("HTML_COMPRESS_WHITESPACE")); // NOI18N
        jPanel1.add(compressWhitespaceCB);

        org.openide.awt.Mnemonics.setLocalizedText(removeCommentsCB, OStrings.getString("HTML_REMOVE_COMMENTS")); // NOI18N
        jPanel1.add(removeCommentsCB);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Checks text value of JTextField if it is a valid regular expression. If not, focus is set to the text field and an alert is shown.
     * @param textfield the text field with the regular expression
     * @return true if regular expression is valid, false otherwise
     */
    private boolean checkRegExp(JTextField textfield) {
        try {
            Pattern.compile(textfield.getText());
        } catch (PatternSyntaxException e) {
            textfield.setCaretPosition(e.getIndex());
            JOptionPane.showMessageDialog(this,
                    e.getLocalizedMessage(), OStrings.getString("HTML_ERROR_CUSTOMREGEXP_TITLE"),
                    JOptionPane.ERROR_MESSAGE);
            textfield.grabFocus();
            return false;
        }
        return true;
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_okButtonActionPerformed
    {
        if (!checkRegExp(skipRegExpTF)) {
            return;
        }
        if (alwaysRB.isSelected())
            options.setRewriteEncoding(HTMLOptions.REWRITE_MODE.ALWAYS);
        else if (ifHasHeaderRB.isSelected())
            options.setRewriteEncoding(HTMLOptions.REWRITE_MODE.IFHEADER);
        else if (ifHasMetaRB.isSelected())
            options.setRewriteEncoding(HTMLOptions.REWRITE_MODE.IFMETA);
        else if (neverRB.isSelected())
            options.setRewriteEncoding(HTMLOptions.REWRITE_MODE.NEVER);

        options.setTranslateHref(translateHrefCB.isSelected());
        options.setTranslateSrc(translateSrcCB.isSelected());
        options.setTranslateLang(translateLangCB.isSelected());
        options.setTranslateValue(translateValueCB.isSelected());
        options.setTranslateButtonValue(translateButtonValueCB.isSelected());
        options.setTranslateHreflang(translateHreflangCB.isSelected());
        options.setParagraphOnBr(paragraphOnBrCB.isSelected());
        options.setCompressWhitespace(compressWhitespaceCB.isSelected());
        options.setRemoveComments(removeCommentsCB.isSelected());
        options.setSkipRegExp(skipRegExpTF.getText());
        options.setSkipMeta(skipMetaTF.getText());
        options.setIgnoreTags(ignoreTagsTF.getText());

        doClose(RET_OK);
    }// GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_cancelButtonActionPerformed
    {
        doClose(RET_CANCEL);
    }// GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt)// GEN-FIRST:event_closeDialog
    {
        doClose(RET_CANCEL);
    }// GEN-LAST:event_closeDialog

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alwaysRB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox compressWhitespaceCB;
    private javax.swing.JRadioButton ifHasHeaderRB;
    private javax.swing.JRadioButton ifHasMetaRB;
    private javax.swing.JTextField ignoreTagsTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton neverRB;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox paragraphOnBrCB;
    private javax.swing.JCheckBox removeCommentsCB;
    private javax.swing.JTextField skipMetaTF;
    private javax.swing.JTextField skipRegExpTF;
    private javax.swing.JCheckBox translateButtonValueCB;
    private javax.swing.JCheckBox translateHrefCB;
    private javax.swing.JCheckBox translateHreflangCB;
    private javax.swing.JCheckBox translateLangCB;
    private javax.swing.JCheckBox translateSrcCB;
    private javax.swing.JCheckBox translateValueCB;
    // End of variables declaration//GEN-END:variables
}
