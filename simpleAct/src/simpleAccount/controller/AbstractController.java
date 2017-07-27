package simpleAccount.controller;
import simpleAccount.model.Model;
import simpleAccount.view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractController.
 */
public abstract class AbstractController implements Controller {
	
	/** The view. */
	private View view;
	
	/** The model. */
	private Model model;
	
	/* (non-Javadoc)
	 * @see simpleAccount.controller.Controller#setModel(simpleAccount.model.Model)
	 */
	public void setModel(Model model){this.model = model;}
	
	/* (non-Javadoc)
	 * @see simpleAccount.controller.Controller#getModel()
	 */
	public Model getModel(){return model;}
	
	/* (non-Javadoc)
	 * @see simpleAccount.controller.Controller#getView()
	 */
	public View getView(){return view;}
	
	/* (non-Javadoc)
	 * @see simpleAccount.controller.Controller#setView(simpleAccount.view.View)
	 */
	public void setView(View view){this.view = view;}

}