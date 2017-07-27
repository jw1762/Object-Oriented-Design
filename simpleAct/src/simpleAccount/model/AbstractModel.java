package simpleAccount.model;
import java.util.ArrayList;
import java.util.Iterator;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractModel.
 */
public abstract class AbstractModel implements Model {
	
	/** The listeners. */
	private ArrayList listeners = new ArrayList(5);
	
	/* (non-Javadoc)
	 * @see simpleAccount.model.Model#notifyChanged(simpleAccount.model.ModelEvent)
	 */
	public void notifyChanged(ModelEvent event){
		ArrayList list = (ArrayList)listeners.clone();
		Iterator it = list.iterator();
		while(it.hasNext()){
			ModelListener ml = (ModelListener)it.next();
			ml.modelChanged(event);
		}
	}
	
	/**
	 * Adds the model listener.
	 *
	 * @param l the l
	 */
	public void addModelListener(ModelListener l){
		listeners.add(l);
	}
	
	/**
	 * Removes the model listener.
	 *
	 * @param l the l
	 */
	public void removeModelListener(ModelListener l){
		listeners.remove(l);
	}
}