package simpleAccount.view;
import javax.swing.*;
import simpleAccount.model.Model;
import simpleAccount.model.AbstractModel;
import simpleAccount.model.ModelListener;
import simpleAccount.controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Class JFrameView.
 */
abstract public class JFrameView extends JFrame implements View, ModelListener {
	
	/** The model. */
	private Model model;
	
	/** The controller. */
	private Controller controller;
	
	/**
	 * Instantiates a new j frame view.
	 *
	 * @param model the model
	 * @param controller the controller
	 */
	public JFrameView (Model model, Controller controller){
		setModel(model);
		setController(controller);
	}
	
	/**
	 * Register with model.
	 */
	public void registerWithModel(){
		((AbstractModel)model).addModelListener(this);
	}
	
	/* (non-Javadoc)
	 * @see simpleAccount.view.View#getController()
	 */
	public Controller getController(){return controller;}
	
	/* (non-Javadoc)
	 * @see simpleAccount.view.View#setController(simpleAccount.controller.Controller)
	 */
	public void setController(Controller controller){this.controller = controller;}
	
	/* (non-Javadoc)
	 * @see simpleAccount.view.View#getModel()
	 */
	public Model getModel(){return model;}
	
	/* (non-Javadoc)
	 * @see simpleAccount.view.View#setModel(simpleAccount.model.Model)
	 */
	public void setModel(Model model) {
		this.model = model;
		registerWithModel();
	}
}