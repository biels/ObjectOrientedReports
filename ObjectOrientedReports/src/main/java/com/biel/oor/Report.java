package com.biel.oor;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biel.xre.generation.XHTMLReport;
import com.itextpdf.text.Element;

public abstract class Report {
	private final static Logger l = LoggerFactory.getLogger(Report.class);
	//Report context variables
	private Model m;
	private Controller c;
	private View v;
	
	public Report() {
		super();
		try {
			m = getModelType().cast(getModelType().getConstructor(getClass()).newInstance(this));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			l.error("Error while creating model instance");
			e.printStackTrace();
		}
		try {
			c = getControllerType().cast(getControllerType().getConstructor(getClass()).newInstance(this));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			l.error("Error while creating controller instance");
			e.printStackTrace();
		}
		try {
			v = getViewType().cast(getViewType().getConstructor(getClass()).newInstance(this));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			l.error("Error while creating view instance");
			e.printStackTrace();
		}
	}
	
	public class Model{
		private String username;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

	}
	public abstract class Controller{
		public String getGreeting(){
			return MessageFormat.format("Hello {0}", m.getUsername());
		}
	}
	public abstract class View extends XHTMLReport{

	}
	@SuppressWarnings("unchecked")
	protected <T extends Model> T getModel(Class<T> type){
		return (T) m;
	}
	@SuppressWarnings("unchecked")
	protected <T extends Controller> T getController(Class<T> type){
		return (T) c;
	}
	@SuppressWarnings("unchecked")
	protected <T extends View> T getView(Class<T> type){
		return (T) v;
	}
	private Class<?> getMVCClass(String elementName){
		String clsName = getClass().getSimpleName();
		String bareName = clsName.substring(0, Math.max(0, clsName.length() - 6)); //Remove "Report"
		String name = bareName + elementName;
		Class<?>[] classes = getClass().getClasses();
		for(Class<?> cls : classes)
			if(name.equalsIgnoreCase(cls.getSimpleName())) return cls;
		l.error(elementName + " type not found. Check that " + name + " exists inside " + clsName);
		return null;
	}
	@SuppressWarnings("unchecked")
	public Class<? extends Model> getModelType(){	
		return (Class<? extends Model>) getMVCClass("Model");
	}
	@SuppressWarnings("unchecked")
	public Class<? extends Controller> getControllerType(){	
		return (Class<? extends Controller>) getMVCClass("Controller");
	}
	@SuppressWarnings("unchecked")
	public Class<? extends View> getViewType(){	
		return (Class<? extends View>) getMVCClass("View");
	}
	
}
