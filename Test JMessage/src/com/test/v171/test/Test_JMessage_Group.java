package com.test.v171.test;

import java.util.Random;


import com.example.jpushdemo.MainActivity;
import com.robotium.solo.Solo;

import android.annotation.SuppressLint;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Test_JMessage_Group extends ActivityInstrumentationTestCase2<MainActivity> {

	private static final String PadgeName = "com.test.v171"; //Ӧ�ð���
	private String addGroupMember = "";
	private String removeGroupMember = "";
	private String GroupID = null; //����GroupID
	private Solo solo;
	private String ExitUserName = "P1111";	//���ڵ��û���
	private String ExitUserPasswd = "123456";	//�����û���������
	private String TAG = "JPush";
	
	
	
	@SuppressLint("NewApi")
	public Test_JMessage_Group() {
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
	
	
	/**
	 * ��¼�ӿ�
	 * @throws InterruptedException 
	 * */
	public  void Login(String user,String pwd) throws InterruptedException
	{
		solo.scrollUp();
		solo.clearEditText(2);
		solo.clearEditText(3);
		solo.enterText(2, user);
		solo.enterText(3, pwd);
		solo.clickOnButton("imlogin");
		solo.sleep(3000);
	}
	
	/**
	 * ��ȡGroup ID
	 * 
	 * */
	public String getGroupID()
	{
		solo.scrollUp();
		solo.clickOnButton("getGroupIDList");
		solo.sleep(3000);
		
		TextView textView = (TextView) solo.getView(solo.getCurrentActivity().getResources().getIdentifier("getGroupIDList_groupId","id",PadgeName));
		String tag = null;
		tag = textView.getText().toString();
		
		String[] sArray = tag.split(",");
		if (sArray.length == 100)
			Log.d(TAG, ExitUserName+"�û���Ⱥ�������Ѿ�����100����");
		for (int num =0;num < sArray.length; num++) {
			// ��ȡ���µ�Group id
			if ( num == sArray.length-1&&sArray.length !=0)
			{
				GroupID = sArray[num];
			}
		}
		
		return GroupID;
	}
	
	/**
	 * ����Ⱥ�飬����ֵΪ�µ�Ⱥ��ID��
	 * 
	 * */
	public void createGroup(String GroupName,String GroupDesc)
	{
		solo.scrollUp();
		
		EditText editTextname = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("createGroup_groupName","id",PadgeName));
		EditText editTextdesc = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("createGroup_groupDesc","id",PadgeName));
		
		solo.clearEditText(editTextname);
		solo.clearEditText(editTextdesc);

		solo.enterText(editTextname, GroupName);
		solo.enterText(editTextdesc, GroupDesc);
		
		solo.clickOnButton("createGroup");
		solo.sleep(3000);
		
	
	}
	
	
	/**
	 *  �ӷ������ϻ�ȡȺ��Ϣ��������Ⱥ��Ա��username��
	 *  getGroupMembersFromServer
	 * */
	public void getGroupInfo(String GID)
	{
		solo.scrollUp();
		
		EditText editTextgid = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("getGroupInfoFromServer_groupId","id",PadgeName));
		solo.clearEditText(editTextgid);
		solo.enterText(editTextgid,GID );
		solo.clickOnButton("getGroupInfoFromServer");
		solo.sleep(3000);
	}
	
	/**
	 *	��ȡȺ��Ա�б� 
	 * 
	 */
	public void getGroupMembers(String GID)
	{
		solo.scrollUp();
		
		EditText editTextgid = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("getGroupMembersFromServer_groupId","id",PadgeName));
		solo.clearEditText(editTextgid);
		solo.enterText(editTextgid,GID );
		solo.clickOnButton("getGroupMembersFromServer");
		solo.sleep(3000);
	}
	
	/**
	 * 	����Ⱥ������Ϣ
	 * 
	 * */
	public void updateGroupName(String GID,String GName)
	{
		solo.scrollUp();
			
		EditText editTextgid = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("updateGroupName_groupID","id",PadgeName));
		EditText editTextgname = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("updateGroupName_groupName","id",PadgeName));
		solo.clearEditText(editTextgid);
		solo.clearEditText(editTextgname);
		solo.enterText(editTextgid,GID );
		solo.enterText(editTextgname, GName);
	
		solo.clickOnButton("updateGroupName");
		solo.sleep(3000);
	}
	
	/**
	 * 	����Ⱥ������Ϣ
	 * 
	 * */
	public void updateGroupDesc(String GID,String GDesc)
	{
		solo.scrollUp();
				
		EditText editTextgid = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("updateGroupDescription_groupID","id",PadgeName));
		EditText editTextgdesc = (EditText)solo.getView(solo.getCurrentActivity().getResources().getIdentifier("updateGroupDescription_groupDesc","id",PadgeName));
		solo.clearEditText(editTextgid);
		solo.clearEditText(editTextgdesc);
		solo.enterText(editTextgid,GID );
		solo.enterText(editTextgdesc, GDesc);
	
		solo.clickOnButton("updateGroupDescription");
		solo.sleep(3000);
	}
	
	
	public void testGroup() throws InterruptedException
	{
		if(solo.searchButton("IM Android�ͻ��˶���ӿڻ������ܲ���"))
			solo.clickOnButton("IM Android�ͻ��˶���ӿڻ������ܲ���");
		
		solo.clickOnButton("ע��_��¼_������Ϣ");
		Login(ExitUserName, ExitUserPasswd);
		solo.goBack();
		solo.clickOnButton("Ⱥ��ά��");
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========��ʼ����==========");
		Log.d(TAG, "===========Group api==========");
		
//      1.1 ���Դ���Ⱥ��û��Ⱥ���ƣ�����Ⱥ���������
		Log.d(TAG, "1.1 ����Ⱥ����Ϊ�գ�Ⱥ����Ϊ��desc");
		createGroup("","desc");
		
		
//      1.2 ���Դ���Ⱥ����������Ⱥ���ƺ�Ⱥ����
		String GroupN = null;
		String GroupD = null;
		GroupN = RandomString(5);
		GroupD = RandomString(10);
		Log.d(TAG, "1.2 ����Ⱥ����Ϊ:"+GroupN+"Ⱥ����Ϊ"+GroupD);
		createGroup(GroupN, GroupD);
		GroupID = getGroupID();
		Log.d(TAG, "���������ϢΪ��"+GroupID);
		
		
//		1.3  ���Ի�ȡȺ����Ϣ
		Log.d(TAG, "1.3 ��ȡȺ�����Ϣ��ȺID:"+GroupID);
		getGroupInfo(GroupID);
		
//		1.4  ��ȡȺ��Ա��list
		Log.d(TAG, "1.4 ��ȡȺ���Ⱥ��Ա��ȺID:"+GroupID);
		getGroupMembers(GroupID);

//		1.5 ����Ⱥ����
		String GNa = RandomString(20);
		Log.d(TAG, "1.5 ����Ⱥ������ƣ�ȺID:"+GroupID+"==="+"Ⱥ����:"+GNa);
		updateGroupName(GroupID, GNa);
		getGroupInfo(GroupID);
		
// 		1.6 ����Ⱥ����
		String GDes = RandomString(30);
		Log.d(TAG, "1.6 ����Ⱥ���������ȺID:"+GroupID+"==="+"Ⱥ����:"+GDes);
		updateGroupDesc(GroupID, GDes);
		getGroupInfo(GroupID);
     

	}

}
