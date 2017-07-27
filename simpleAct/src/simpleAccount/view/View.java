package simpleAccount.view;
import simpleAccount.model.Model;
import simpleAccount.controller.Controller;

// TODO: Auto-generated Javadoc
/**
 * The Interface View.
 */
public interface View {
	
	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	Controller getController();
	
	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	void setController(Controller controller);
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	Model getModel();
	
	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	void setModel(Model model);
}