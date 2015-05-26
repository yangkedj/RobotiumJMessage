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

	private static final String PadgeName = "com.test.v171"; //应用包名
	private String addGroupMember = "";
	private String removeGroupMember = "";
	private String GroupID = null; //返回GroupID
	private Solo solo;
	private String ExitUserName = "P1111";	//存在的用户名
	private String ExitUserPasswd = "123456";	//存在用户名的密码
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
	 * 随机字符串
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
	 * 登录接口
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
	 * 获取Group ID
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
			Log.d(TAG, ExitUserName+"用户的群组数量已经到达100上限");
		for (int num =0;num < sArray.length; num++) {
			// 获取最新的Group id
			if ( num == sArray.length-1&&sArray.length !=0)
			{
				GroupID = sArray[num];
			}
		}
		
		return GroupID;
	}
	
	/**
	 * 创建群组，返回值为新的群组ID，
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
	 *  从服务器上获取群信息（不包含群成员的username）
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
	 *	获取群成员列表 
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
	 * 	更新群名称信息
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
	 * 	更新群描述信息
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
		if(solo.searchButton("IM Android客户端对外接口基本功能测试"))
			solo.clickOnButton("IM Android客户端对外接口基本功能测试");
		
		solo.clickOnButton("注册_登录_个人信息");
		Login(ExitUserName, ExitUserPasswd);
		solo.goBack();
		solo.clickOnButton("群组维护");
		Log.d(TAG, "==========================");
		Log.d(TAG, "===========开始测试==========");
		Log.d(TAG, "===========Group api==========");
		
//      1.1 测试创建群组没有群名称，但又群描述的情况
		Log.d(TAG, "1.1 测试群名称为空，群描述为：desc");
		createGroup("","desc");
		
		
//      1.2 测试创建群组正常输入群名称和群描述
		String GroupN = null;
		String GroupD = null;
		GroupN = RandomString(5);
		GroupD = RandomString(10);
		Log.d(TAG, "1.2 测试群名称为:"+GroupN+"群描述为"+GroupD);
		createGroup(GroupN, GroupD);
		GroupID = getGroupID();
		Log.d(TAG, "创建组的信息为："+GroupID);
		
		
//		1.3  测试获取群的信息
		Log.d(TAG, "1.3 获取群组的信息，群ID:"+GroupID);
		getGroupInfo(GroupID);
		
//		1.4  获取群成员的list
		Log.d(TAG, "1.4 获取群组的群成员，群ID:"+GroupID);
		getGroupMembers(GroupID);

//		1.5 更新群名称
		String GNa = RandomString(20);
		Log.d(TAG, "1.5 更新群组的名称，群ID:"+GroupID+"==="+"群名称:"+GNa);
		updateGroupName(GroupID, GNa);
		getGroupInfo(GroupID);
		
// 		1.6 更新群描述
		String GDes = RandomString(30);
		Log.d(TAG, "1.6 更新群组的描述，群ID:"+GroupID+"==="+"群描述:"+GDes);
		updateGroupDesc(GroupID, GDes);
		getGroupInfo(GroupID);
     

	}

}
