package com.test.v171.test;

import java.util.Random;

import com.example.jpushdemo.MainActivity;
import com.robotium.solo.Solo;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;

public class Test_JMessage_Profile extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	private String IllegalUserName = "Illegal_!@#$";
	private String IllegalUserPasswd = "Illegal_passwd";
	private String UnExitUserName = "Un_Exit_User";
	private String ExitUserName = "P1111";
	private String ExitUserPasswd = "123456";
	private String TAG = "JPush";
//  ���Եİ���
	private static String PadgeName = "com.test.v171";
	
	@SuppressLint("NewApi")
	public Test_JMessage_Profile() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		try {
			 solo.finalize();
			 solo.finishOpenedActivities();
			 } catch (Throwable e) {
			 e.printStackTrace();
			 }
			 getActivity().finish();
			 super.tearDown();
	}

	/**
	 *  С��4�ֽ�
	 * */
	public String LessThan4bytes()
	{
		return RandomString(3);
	}
	
	/**
	 *  ����64�ֽ�
	 * */
	public String MoreThan64bytes()
	{
		return RandomString(65);
	}
	
	/**
	 *  ����250�ֽ�
	 * */
	public String MoreThan250bytes()
	{
		return RandomString(251);
	}
	
	/**
	 *  ����128�ֽ�
	 * */
	public String MoreThan128bytes()
	{
		return RandomString(129);
	}
	
	
	/**
	 * ע��ӿڣ�
	 * @throws InterruptedException 
	 * */
	public  void Register(String user,String pwd) throws InterruptedException
	{
		solo.scrollUp();
		solo.clearEditText(0);
		solo.clearEditText(1);
		solo.enterText(0, user);
		solo.enterText(1, pwd);
		
		Log.d(TAG, "ע���û�Ϊ: "+user);
		Log.d(TAG, "ע������:"+pwd);
		
		solo.clickOnButton("register");
		solo.sleep(3000);
	}
	
	/**
	 * ��¼�ӿ�
	 * @throws InterruptedException 
	 * */
	public  void Login(String user,String pwd) throws InterruptedException
	{
		solo.scrollUp();
		solo.scrollUp();
		solo.clearEditText(2);
		solo.clearEditText(3);
		solo.enterText(2, user);
		solo.enterText(3, pwd);
		solo.clickOnButton("imlogin");
		solo.sleep(3000);
	}
	
	/**
	 * �ǳ��ӿ�
	 * @throws InterruptedException 
	 * 
	 * */
	public  void Logout() throws InterruptedException
	{
		solo.scrollUp();
		solo.clickOnButton("imlogout");
		solo.sleep(3000);
	}
	
	/**
	 * ��ȡ���ظ�����Ϣ�ӿ�
	 * @throws InterruptedException 
	 * */
	public  void getCurrentUser() throws InterruptedException
	{
		solo.scrollUp();
		solo.clickOnButton("getCurrnetUser");
		solo.sleep(3000);
	}
	
	
	
	/***
	 * �������ȡ������Ϣ�Ľӿ�
	 * @throws InterruptedException 
	 * 
	 */
	public  void getUserInfo(String username) throws InterruptedException
	{
//      ��һ��������id���ڶ����̶����������ǳ������
		solo.scrollUp();
		int typeId = solo.getCurrentActivity().getResources().getIdentifier("getUserInfo_username", "id",PadgeName );
		EditText v = (EditText)solo.getView(typeId);
		solo.clearEditText(v);
		solo.enterText(v, username);
		
//      �����ѯ				
		solo.clickOnButton("getUserInfo");
		solo.sleep(3000);
	}
	
	/**
	 * �޸�����ӿ�
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserPassword(String oldpasswd,String newpasswd) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdold = solo.getCurrentActivity().getResources().getIdentifier("updateUserPassword_oldPassword", "id",PadgeName );
		EditText vold = (EditText)solo.getView(typeIdold);
		
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserPassword_newPassword", "id",PadgeName );
		EditText vnew = (EditText)solo.getView(typeIdnew);
		
		solo.clearEditText(vold);
		solo.clearEditText(vnew);
		solo.enterText(vold, oldpasswd);
		solo.enterText(vnew, newpasswd);
		
//      ����޸�
		solo.clickOnButton("updateUserPassword");
		solo.sleep(3000);
	}
	
	/**
	 * �޸��ǳ�
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserNickName(String nickname) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserNickName_nickname", "id",PadgeName );
		EditText vnickN = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vnickN);
		solo.enterText(vnickN, nickname);
		
//      ����޸��ǳ�
		solo.clickOnButton("updateUserNickName");
		solo.sleep(3000);
	}
	
	/**
	 * �޸�����
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserBirthday(String birthday) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserBirthday_birthday", "id",PadgeName );
		EditText vbirth = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vbirth);
		solo.enterText(vbirth, birthday);
		solo.clickOnButton("updateUserBirthday");
		solo.sleep(3000);
	}
	
	/**
	 * �޸ĸ���ǩ��
	 * @throws InterruptedException 
	 * 
	 * */
	public  void updateUserSignature(String signature) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserSignature_signature", "id",PadgeName );
		EditText vsignature = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vsignature);
		solo.enterText(vsignature, signature);
		
//      �������ǩ��
		solo.clickOnButton("updateUserSignature");
		solo.sleep(3000);
	}
	
	/**
	 * �޸��Ա�=== �� Ů δ֪
	 * @throws InterruptedException 
	 * */
	public  void updateUserGender(String gender) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserGender_gender", "id",PadgeName );
		EditText vgender = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vgender);
		solo.enterText(vgender, gender);
		
//      ����޸��Ա�
		solo.clickOnButton("updateUserGender");
		solo.sleep(3000);
	}
	
	/**
	 * �޸ĵ���
	 * @throws InterruptedException 
	 * */
	public  void updateUserRegion(String region) throws InterruptedException
	{
		solo.scrollUp();
		int typeIdnew = solo.getCurrentActivity().getResources().getIdentifier("updateUserRegion_region", "id",PadgeName );
		EditText vregion = (EditText)solo.getView(typeIdnew);
		solo.clearEditText(vregion);
		solo.enterText(vregion, region);
		
//      ����޸ĵ�����Ϣ
		solo.clickOnButton("updateUserRegion");
		solo.sleep(3000);
	}
	
	
	/**
	 * ����ַ���
	 * */
	public  String RandomString(int length) {  
	    String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@-_.";  
	    Random random = new Random();  
	    StringBuffer buf = new StringBuffer();  
	    for (int i = 0; i < length; i++) {  
	        int num = random.nextInt(62);  
	        buf.append(str.charAt(num));  
	    }  
	    return buf.toString();  
	}  

	
	
	public void testProfile() throws InterruptedException
	{
		if(solo.searchButton("IM Android�ͻ��˶���ӿڻ������ܲ���"))
			solo.clickOnButton("IM Android�ͻ��˶���ӿڻ������ܲ���");
		
		solo.clickOnButton("ע��_��¼_������Ϣ");
		
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========��ʼ����==========");
		Log.d(TAG, "===========Profile api==========");
		
		Login(ExitUserName, ExitUserPasswd);
		
		
		Log.d(TAG, "@@@@@@ 5����Profileά�������������û���¼");
		
		
		// ��ȡ���ظ�����Ϣ
		Log.d(TAG, "@@@@@@ 5.1 ��ȡ���ظ�����Ϣ");
		getCurrentUser();
		
		
		// ���������ȡ������Ϣ
		Log.d(TAG, "@@@@@@ 5.2.1 ���Ի�ȡ�������û�:"+UnExitUserName+"��userinfo,");
		getUserInfo(UnExitUserName);
		
		Log.d(TAG, "@@@@@@ 5.2.2 ���ԷǷ��û���:"+IllegalUserName+"��userinfo");
		getUserInfo(IllegalUserName);
		
		Log.d(TAG, "@@@@@@ 5.2.3 �����Ѿ����ڵ��û�"+ExitUserName+"��userinfo,");
		getUserInfo(ExitUserName);
		
		// �޸�����
		Log.d(TAG, "@@@@@@ 5.3.1�޸ĸ�������-�����û�����:"+ExitUserName+",�������ľ�����:"+IllegalUserPasswd);
		updateUserPassword(IllegalUserPasswd, "111111");
		
		Log.d(TAG, "@@@@@@ 5.3.2�޸ĸ�������-�����û�����:"+ExitUserName+",������ȷ�ľ�����:"+ExitUserPasswd+"����������루С��4λ������128λ��");
		String LT4 = LessThan4bytes();
		Log.d(TAG, "С��4λ��������ֵ:"+LT4);
		updateUserPassword(ExitUserPasswd, LT4);
		
		String MT128 = MoreThan128bytes();
		Log.d(TAG, "����128λ��������ֵ:"+MT128);
		updateUserPassword(ExitUserPasswd, MT128);
		
		Log.d(TAG, "@@@@@@ 5.3.3�޸ĸ�������-�����û�����:"+ExitUserName+",������ȷ�ľ�����:"+ExitUserPasswd+"�Ϸ���������:"+"111111");
		updateUserPassword(ExitUserPasswd, "111111");
		
		Log.d(TAG, "�޸�������󣬲��Ե�¼�Ƿ�ɹ�");
		Login(ExitUserName, "111111");
		
		Log.d(TAG, "��¼���޸Ļ�ԭ���ľ�����");
		updateUserPassword("111111",ExitUserPasswd);
		
		
		// �޸ĸ����ǳ�
		Log.d(TAG, "@@@@@@ 5.4.1�޸ĸ����ǳ�-������64�ֽ�");
		String LT64 = RandomString(10);
		Log.d(TAG, "С��64λ���ǳ�ֵ:"+LT64);
		updateUserNickName(LT64);
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "@@@@@@ 5.4.2�޸ĸ����ǳ�-���Գ���64�ֽ�");
		String MT64 = MoreThan64bytes();
		Log.d(TAG, "����64λ���ǳ�ֵ:"+MT64);
		updateUserNickName(MT64);
		getUserInfo(ExitUserName);
		
		// �޸�����
		Log.d(TAG, "@@@@@@ 5.5�޸�������Ϣ");
		updateUserBirthday(RandomString(5));
		
		
		// �޸ĸ���ǩ��
		Log.d(TAG, "@@@@@@ 5.6.1�޸ĸ���ǩ����Ϣ");
		String nicknl = RandomString(5);
		Log.d(TAG, "5λ���ȵ��ǳ�ֵ:"+nicknl);
		updateUserSignature(nicknl);
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "@@@@@@ 5.6.2�޸ĸ���ǩ����Ϣ-���Գ���250�ֽ�");
		String MT250 = MoreThan250bytes();
		Log.d(TAG, "����250λ�ĸ���ǩ��ֵ:"+MT250);
		updateUserSignature(MT250);
		getUserInfo(ExitUserName);
		
		// �޸��Ա�
		Log.d(TAG, "@@@@@@ 5.7.1�޸��Ա���Ϣ-δ֪");
		updateUserGender("δ֪");
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "@@@@@@ 5.7.2�޸��Ա���Ϣ-��");
		updateUserGender("��");
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "@@@@@@ 5.7.3�޸��Ա���Ϣ-Ů");
		updateUserGender("Ů");
		getUserInfo(ExitUserName);
		
		// �޸ĵ���
		Log.d(TAG, "@@@@@@ 5.8.1�޸ĵ�����Ϣ");
		updateUserRegion(RandomString(6));
		getUserInfo(ExitUserName);
		
		Log.d(TAG, "@@@@@@ 5.8.2�޸ĵ�����Ϣ-����250�ֽ�");
		String MT250_ = MoreThan250bytes();
		Log.d(TAG, "����250λ�ĵ���ֵ:"+MT250);
		updateUserRegion(MT250_);
		getUserInfo(ExitUserName);
		
	
	}
	
}
