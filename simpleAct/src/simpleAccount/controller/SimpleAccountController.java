package simpleAccount.controller;
import simpleAccount.view.SimpleAccountView;
import simpleAccount.model.SimpleAccountModel;
import simpleAccount.view.JFrameView;
import simpleAccount.view.USDEdit;
import simpleAccount.view.EuroEdit;
import simpleAccount.view.YuanEdit;
import simpleAccount.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleAccountController.
 */
public class SimpleAccountController extends AbstractController {
	
	/**
	 * Instantiates a new simple account controller.
	 */
	public SimpleAccountController(){
		setModel(new SimpleAccountModel());
		setView(new SimpleAccountView((SimpleAccountModel)getModel(), this));
		((JFrameView)getView()).setVisible(true);
	}
	
	/**
	 * Operation.
	 *
	 * @param option the option
	 * @param user the user
	 * @param amount the amount
	 */
	public void operation(String option, User user, double amount){
		if(option.equals(SimpleAccountView.USD))
		{
			setView(new USDEdit((SimpleAccountModel)getModel(), this, user));
		}
		else if(option.equals(SimpleAccountView.EURO))
		{
			setView(new EuroEdit((SimpleAccountModel)getModel(), this, user));
		}
		else if(option.equals(SimpleAccountView.YUAN))
		{
			setView(new YuanEdit((SimpleAccountModel)getModel(), this, user));
		}
		else if(option.equals(USDEdit.WITHDRAW_USD))
		{
			((SimpleAccountModel)getModel()).withdrawUSD(user, amount);
		}
		else if(option.equals(USDEdit.DEPOSIT_USD))
		{
			((SimpleAccountModel)getModel()).depositUSD(user, amount);
		}
		else if(option.equals(EuroEdit.WITHDRAW_EURO))
		{
			((SimpleAccountModel)getModel()).withdrawEURO(user, amount);
		}
		else if(option.equals(EuroEdit.DEPOSIT_EURO))
		{
			((SimpleAccountModel)getModel()).depositEURO(user, amount);
		}
		else if(option.equals(YuanEdit.WITHDRAW_YUAN))
		{
			((SimpleAccountModel)getModel()).withdrawYUAN(user, amount);
		}
		else if(option.equals(YuanEdit.DEPOSIT_YUAN))
		{
			((SimpleAccountModel)getModel()).depositYUAN(user, amount);
		}
		else if(option.equals(SimpleAccountView.SAVE))
		{
			((SimpleAccountModel)getModel()).save();
		}
		else if(option.equals(SimpleAccountView.EXIT))
		{
			((SimpleAccountModel)getModel()).exit();
		}
	}
}