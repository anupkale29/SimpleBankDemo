/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.utility;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import SecuGen.FDxSDKPro.jni.JSGFPLib;
import SecuGen.FDxSDKPro.jni.SGDeviceInfoParam;
import SecuGen.FDxSDKPro.jni.SGFDxDeviceName;
import SecuGen.FDxSDKPro.jni.SGFDxErrorCode;
import SecuGen.FDxSDKPro.jni.SGFingerInfo;
import SecuGen.FDxSDKPro.jni.SGFingerPosition;
import SecuGen.FDxSDKPro.jni.SGImpressionType;
import SecuGen.FDxSDKPro.jni.SGPPPortAddr;

import com.bank.domain.creditdebit.CreditDebitCardInfo;
import com.bank.service.users.IUserService;


public class JSGD extends javax.swing.JFrame {

    
    //Private instance variables
    private long deviceName;
    private long devicePort;
    private JSGFPLib fplib = null;
    private long ret;
    private boolean bLEDOn;
    private byte[] regMin1 = new byte[400];
    private byte[] regMin2 = new byte[400];
    private byte[] regMin3 = new byte[400];
    private byte[] vrfMin  = new byte[400];
    private SGDeviceInfoParam deviceInfo = new SGDeviceInfoParam();
    private BufferedImage imgRegistration1;
    private BufferedImage imgRegistration2;
    private BufferedImage imgRegistration3;
    private BufferedImage imgVerification;
    private boolean r1Captured = false;
    private boolean r2Captured = false;
    private boolean r3Captured = false;
    private boolean v1Captured = false;
    int imageQuality=50;//10 to hundread
    int timeOutSecs=5;//1 to 10
    private CreditDebitCardInfo creditDebitCardInfo=null;
    private IUserService iUserService;
    
    public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}
    
	public CreditDebitCardInfo getCreditDebitCardInfo() {
		return creditDebitCardInfo;
	}

	public void setCreditDebitCardInfo(CreditDebitCardInfo creditDebitCardInfo) {
		this.creditDebitCardInfo = creditDebitCardInfo;
	}

	/**
     * Creates new form JSGDDemo
     */
    public JSGD() {
        bLEDOn = false;
        initComponents();
        disableControls();
    }
    
    private void disableControls()
    {
//        this.jButtonToggleLED.setEnabled(false);
//        this.jButtonCapture.setEnabled(false);
        this.jButtonCaptureR1.setEnabled(false);
        this.jButtonCaptureR2.setEnabled(false);
        this.jButtonCaptureR3.setEnabled(false);
//        this.jButtonCaptureV1.setEnabled(false);
        this.jButtonRegister.setEnabled(false);
//        this.jButtonVerify.setEnabled(false);
//        this.jButtonGetDeviceInfo.setEnabled(false);
//        this.jButtonConfig.setEnabled(false);
    }
    
    
    private void enableControls()
    {
//        this.jButtonToggleLED.setEnabled(true);
//        this.jButtonCapture.sCetEnabled(true);
        this.jButtonCaptureR1.setEnabled(true);
        this.jButtonCaptureR2.setEnabled(true);
        this.jButtonCaptureR3.setEnabled(true);
//        this.jButtonCaptureV1.setEnabled(true);
//        this.jButtonGetDeviceInfo.setEnabled(true);
//        this.jButtonConfig.setEnabled(true);
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonInit = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();
        jButtonCaptureR1 = new javax.swing.JButton();
        jButtonCaptureR2 = new javax.swing.JButton();
        jButtonCaptureR3 = new javax.swing.JButton();
        jLabelRegisterImage1 = new javax.swing.JLabel();
        jLabelRegisterImage3 = new javax.swing.JLabel();
        jLabelRegisterImage2 = new javax.swing.JLabel();
        jProgressBarR1 = new javax.swing.JProgressBar();
        jProgressBarR2 = new javax.swing.JProgressBar();
        jProgressBarR3 = new javax.swing.JProgressBar();
        jButtonRegister = new javax.swing.JButton();

//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonInit.setText("INITIALIZE");
        jButtonInit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInitActionPerformed(evt);
            }
        });

        jLabelStatus.setPreferredSize(new java.awt.Dimension(85, 23));

        jButtonCaptureR1.setText("Capture R1");
        jButtonCaptureR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaptureR1ActionPerformed(evt);
            }
        });

        jButtonCaptureR2.setText("Capture R2");
        jButtonCaptureR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaptureR2ActionPerformed(evt);
            }
        });

        jButtonCaptureR3.setText("Capture R3");
        jButtonCaptureR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCaptureR3ActionPerformed(evt);
            }
        });

        jLabelRegisterImage1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabelRegisterImage3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabelRegisterImage2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButtonRegister.setText("REGISTER");
        jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegisterActionPerformed(evt);
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jProgressBarR1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jButtonCaptureR1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelRegisterImage1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCaptureR2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCaptureR3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jProgressBarR2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelRegisterImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelRegisterImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jProgressBarR3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                .addGap(29, 29, 29))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 29, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonInit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRegisterImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRegisterImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRegisterImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBarR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarR2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBarR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCaptureR1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCaptureR2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCaptureR3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInitActionPerformed
        // TODO add your handling code here:
        int selectedDevice = 0;
        switch(selectedDevice)
        {
            case 0: //USB
            default:
                this.deviceName = SGFDxDeviceName.SG_DEV_AUTO;
                break;
            case 1: //FDU05
                this.deviceName = SGFDxDeviceName.SG_DEV_FDU05;
                break;
            case 2: //FDU04
                this.deviceName = SGFDxDeviceName.SG_DEV_FDU04;
                break;
            case 3: //CN_FDU03
                this.deviceName = SGFDxDeviceName.SG_DEV_FDU03;
                break;
            case 4: //CN_FDU02
                this.deviceName = SGFDxDeviceName.SG_DEV_FDU02;
                break;
        }
        fplib = new JSGFPLib();
        ret = fplib.Init(this.deviceName);
        if ((fplib != null) && (ret  == SGFDxErrorCode.SGFDX_ERROR_NONE))
        {
            this.jLabelStatus.setText("JSGFPLib Initialization Success");
            this.devicePort = SGPPPortAddr.AUTO_DETECT;
//            switch (this.jComboBoxUSBPort.getSelectedIndex())
//            {
//                case 1:
//                case 2:
//                case 3:
//                case 4:
//                case 5:
//                case 6:
//                case 7:
//                case 8:
//                case 9:
//                case 10:
//                    this.devicePort = this.jComboBoxUSBPort.getSelectedIndex() - 1;
//                    break;
//            }
            ret = fplib.OpenDevice(this.devicePort);
            if (ret == SGFDxErrorCode.SGFDX_ERROR_NONE)
            {
                this.jLabelStatus.setText("OpenDevice() Success [" + ret + "]");       
                ret = fplib.GetDeviceInfo(deviceInfo);
                if (ret == SGFDxErrorCode.SGFDX_ERROR_NONE)
                {
//                    this.jTextFieldSerialNumber.setText(new String(deviceInfo.deviceSN()));
//                    this.jTextFieldBrightness.setText(new String(Integer.toString(deviceInfo.brightness)));
//                    this.jTextFieldContrast.setText(new String(Integer.toString((int)deviceInfo.contrast)));
//                    this.jTextFieldDeviceID.setText(new String(Integer.toString(deviceInfo.deviceID)));
//                    this.jTextFieldFWVersion.setText(new String(Integer.toHexString(deviceInfo.FWVersion)));
//                    this.jTextFieldGain.setText(new String(Integer.toString(deviceInfo.gain)));
//                    this.jTextFieldImageDPI.setText(new String(Integer.toString(deviceInfo.imageDPI)));
//                    this.jTextFieldImageHeight.setText(new String(Integer.toString(deviceInfo.imageHeight)));
//                    this.jTextFieldImageWidth.setText(new String(Integer.toString(deviceInfo.imageWidth)));
                    imgRegistration1 = new BufferedImage(deviceInfo.imageWidth, deviceInfo.imageHeight, BufferedImage.TYPE_BYTE_GRAY);
                    imgRegistration2 = new BufferedImage(deviceInfo.imageWidth, deviceInfo.imageHeight, BufferedImage.TYPE_BYTE_GRAY);
                    imgRegistration3 = new BufferedImage(deviceInfo.imageWidth, deviceInfo.imageHeight, BufferedImage.TYPE_BYTE_GRAY);
                    imgVerification = new BufferedImage(deviceInfo.imageWidth, deviceInfo.imageHeight, BufferedImage.TYPE_BYTE_GRAY);
                    this.enableControls();
                }
                else
                    this.jLabelStatus.setText("GetDeviceInfo() Error [" + ret + "]");                                
            }
            else
                this.jLabelStatus.setText("OpenDevice() Error [" + ret + "]");                                
        }
        else
            this.jLabelStatus.setText("JSGFPLib Initialization Failed");
        
     
        
    }//GEN-LAST:event_jButtonInitActionPerformed

    private void enableRegisterAndVerifyControls()
    {
        if (r1Captured && r2Captured && r3Captured)
            this.jButtonRegister.setEnabled(true);
//        if (r1Captured && r2Captured && v1Captured)
//            this.jButtonVerify.setEnabled(true);
    }
    
    
    private void jButtonCaptureR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaptureR2ActionPerformed
        // TODO add your handling code here:
        int[] quality = new int[1];
        byte[] imageBuffer1 = ((java.awt.image.DataBufferByte) imgRegistration2.getRaster().getDataBuffer()).getData();
        long iError = SGFDxErrorCode.SGFDX_ERROR_NONE;
         
        iError = fplib.GetImageEx(imageBuffer1,timeOutSecs * 1000, 0, imageQuality);        
        fplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer1, quality);
        this.jProgressBarR2.setValue(quality[0]);
        SGFingerInfo fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImageQuality = quality[0];
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;

        if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE)
        {            
            this.jLabelRegisterImage2.setIcon(new ImageIcon(imgRegistration2.getScaledInstance(167,166,Image.SCALE_DEFAULT)));
            if (quality[0] == 0)
                this.jLabelStatus.setText("GetImageEx() Success [" + ret + "] but image quality is [" + quality[0] + "]. Please try again"); 
            else
            {            
                this.jLabelStatus.setText("GetImageEx() Success [" + ret + "]"); 

                iError = fplib.CreateTemplate(fingerInfo, imageBuffer1, regMin2);
                if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE)
                {
                   this.jLabelStatus.setText("Second registration image was captured");
                   r2Captured = true;
                   this.enableRegisterAndVerifyControls();
                }
                else
                   this.jLabelStatus.setText("CreateTemplate() Error : " + iError);
            }
         }
         else
            this.jLabelStatus.setText("GetImageEx() Error : " + iError);
        
      
    }//GEN-LAST:event_jButtonCaptureR2ActionPerformed

    private void jButtonCaptureR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaptureR1ActionPerformed
        // TODO add your handling code here:
        int[] quality = new int[1];
        byte[] imageBuffer1 = ((java.awt.image.DataBufferByte) imgRegistration1.getRaster().getDataBuffer()).getData();
        long iError = SGFDxErrorCode.SGFDX_ERROR_NONE;
        
        iError = fplib.GetImageEx(imageBuffer1,timeOutSecs * 1000, 0, imageQuality);        
        fplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer1, quality);
        this.jProgressBarR1.setValue(quality[0]);
        SGFingerInfo fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImageQuality = quality[0];
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;

        if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE)
        {            
            this.jLabelRegisterImage1.setIcon(new ImageIcon(imgRegistration1.getScaledInstance(167,166,Image.SCALE_DEFAULT)));
            if (quality[0] == 0)
                this.jLabelStatus.setText("GetImageEx() Success [" + ret + "] but image quality is [" + quality[0] + "]. Please try again"); 
            else
            {
            
                this.jLabelStatus.setText("GetImageEx() Success [" + ret + "]"); 

                iError = fplib.CreateTemplate(fingerInfo, imageBuffer1, regMin1);
                if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE)
                {
                    this.jLabelStatus.setText("First registration image was captured");
                    r1Captured = true;
                    this.enableRegisterAndVerifyControls();
                }
                 else
                   this.jLabelStatus.setText("CreateTemplate() Error : " + iError);
            }
         }
         else
            this.jLabelStatus.setText("GetImageEx() Error : " + iError);
        
        
    }//GEN-LAST:event_jButtonCaptureR1ActionPerformed

    private void jButtonCaptureR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCaptureR3ActionPerformed
        // TODO add your handling code here:
        
        int[] quality = new int[1];
        byte[] imageBuffer1 = ((java.awt.image.DataBufferByte) imgRegistration3.getRaster().getDataBuffer()).getData();
        long iError = SGFDxErrorCode.SGFDX_ERROR_NONE;
         
        iError = fplib.GetImageEx(imageBuffer1,timeOutSecs * 1000, 0, imageQuality);        
        fplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer1, quality);
        this.jProgressBarR3.setValue(quality[0]);
        SGFingerInfo fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImageQuality = quality[0];
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;

        if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE)
        {            
            this.jLabelRegisterImage3.setIcon(new ImageIcon(imgRegistration3.getScaledInstance(167,166,Image.SCALE_DEFAULT)));
            if (quality[0] == 0)
                this.jLabelStatus.setText("GetImageEx() Success [" + ret + "] but image quality is [" + quality[0] + "]. Please try again"); 
            else
            {            
                this.jLabelStatus.setText("GetImageEx() Success [" + ret + "]"); 

                iError = fplib.CreateTemplate(fingerInfo, imageBuffer1, regMin3);
                if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE)
                {
                   this.jLabelStatus.setText("Third registration image was captured");
                   r3Captured = true;
                   this.enableRegisterAndVerifyControls();
                }
                else
                   this.jLabelStatus.setText("CreateTemplate() Error : " + iError);
            }
         }
         else
            this.jLabelStatus.setText("GetImageEx() Error : " + iError);
        
      
    }//GEN-LAST:event_jButtonCaptureR3ActionPerformed

    private void jButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegisterActionPerformed
        int[] matchScore = new int[1];
         boolean[] matched = new boolean[1];
         long iError;
//         long secuLevel = (long) (this.jComboBoxRegisterSecurityLevel.getSelectedIndex() + 1);
         long secuLevel = (long) (4 + 1);
         matched[0] = false;
         
         iError = fplib.MatchTemplate(regMin1,regMin2, secuLevel, matched); 
         if(iError == SGFDxErrorCode.SGFDX_ERROR_NONE){
              iError = fplib.MatchTemplate(regMin2,regMin3, secuLevel, matched);
                 if(iError == SGFDxErrorCode.SGFDX_ERROR_NONE){
                     matchScore[0] = 0;
                        iError = fplib.GetMatchingScore(regMin1, regMin2, matchScore);
                        int score1=matchScore[0];
                        if(iError == SGFDxErrorCode.SGFDX_ERROR_NONE){
                            matchScore[0] = 0;
                            iError = fplib.GetMatchingScore(regMin2, regMin3, matchScore);
                            if (iError == SGFDxErrorCode.SGFDX_ERROR_NONE) {
                                if (matched[0]) {
                                	if(iUserService!=null&&creditDebitCardInfo!=null){
                                		creditDebitCardInfo.setRegMin1(new String(regMin1));
                                    	creditDebitCardInfo.setRegMin2(new String(regMin2));
                                    	creditDebitCardInfo.setRegMin3(new String(regMin3));
                                    	iUserService.saveCreditDebitCardInfo(creditDebitCardInfo);
                                	}
                                    this.jLabelStatus.setText("Registration Success, Matching Score: " + ((matchScore[0]+score1)/2));
                                } else {
                                    this.jLabelStatus.setText("Registration Fail, Matching Score: " + matchScore[0]);
                                }
                            }
                        }else{
                            this.jLabelStatus.setText("Registration Fail, Matching Score: " + matchScore[0]);
                        }
                 } else
                        this.jLabelStatus.setText( "Registration Fail, MatchTemplate() Error : " + iError);
         } else
                this.jLabelStatus.setText( "Registration Fail, MatchTemplate() Error : " + iError);
         
         
         
     
    }//GEN-LAST:event_jButtonRegisterActionPerformed

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
//        System.exit(0);
    	if(fplib!=null){
    		
    	fplib.CloseDevice();
    	fplib.Close();
    	System.out.println(fplib.jniLoadStatus);
    	}
    	this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_exitForm
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JSGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSGD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JSGD().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCaptureR1;
    private javax.swing.JButton jButtonCaptureR2;
    private javax.swing.JButton jButtonCaptureR3;
    private javax.swing.JButton jButtonInit;
    private javax.swing.JButton jButtonRegister;
    private javax.swing.JLabel jLabelRegisterImage1;
    private javax.swing.JLabel jLabelRegisterImage2;
    private javax.swing.JLabel jLabelRegisterImage3;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JProgressBar jProgressBarR1;
    private javax.swing.JProgressBar jProgressBarR2;
    private javax.swing.JProgressBar jProgressBarR3;
    // End of variables declaration//GEN-END:variables
}
