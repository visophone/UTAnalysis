package cn.utsoft.commons.utanalysis_lib;


import android.content.Context;
import android.webkit.JavascriptInterface;

public class JSUMSAgent {
	Context context;

	public JSUMSAgent(Context context) {
		super();
		this.context = context;
	}
	@JavascriptInterface 
	public void bindUserIdentifier(String identifier){
		UTAgent.bindUserIdentifier(context, identifier);
	}
	@JavascriptInterface 
	public void onError(String errorType,String errorInfo){
		UTAgent.onError(context, errorType,errorInfo);
		
	}
	@JavascriptInterface 
	public void postTags(String tags){
		UTAgent.postTags(context, tags);
	}
	@JavascriptInterface 
	public void onEvent(String event_id){
		UTAgent.onEvent(context, event_id);
	}
	@JavascriptInterface 
	public void onEvent(String event_id, int acc){
		UTAgent.onEvent(context, event_id, acc);
	}
	@JavascriptInterface 
	public void onEvent(String event_id,
			 String label,  int acc) {
	    UTAgent.onEvent(context, event_id, label, acc);
	}
	@JavascriptInterface 
	public void onEvent( String event_id,
			 String label,  String json) {
		UTAgent.onEvent(context, event_id, label, json);
	}
	@JavascriptInterface 
	public void onGenericEvent(String label,String value){
		UTAgent.onGenericEvent(context, label, value);
	}
	@JavascriptInterface
	public void postWebPage(String pageName){
		UTAgent.postWebPage(pageName);
	}
}
