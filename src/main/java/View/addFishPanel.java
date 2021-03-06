package View;

import Model.Model;
import Controller.addFishAction;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Dimension;


/*
	addFishFrame opens a selector GUI where a button can be clicked to pick a fish
	The name of this fish is passed to the model as a string, from where the fish data should be computed
*/
public class addFishPanel extends JPanel
{
	private Model m;
	private JButton addFishButton;

	public addFishPanel(Model m)
	{
		this.m = m;
		this.setLayout(new GridLayout());

		

		
		String buttonText = "Add Fish";
		this.addFishButton = new JButton(buttonText);
		this.addFishButton.addActionListener(new addFishAction(m, this));
		this.add(addFishButton);
	}

	public void addFish(String fishName)
	{
		JButton fishButton = new JButton(fishName);

		// we should always allow adding because otherwise we run into problems when
		// adding one fish although there need to be at least X of them. I think we
		// should just show the warnings instead, and make them as informative as possible
/*
		if(!m.canAddFish(fishName) || fishNames.contains(fishName)){
			fishButton.setEnabled(false);
			if(fishNames.contains(fishName)){
				fishButton.setToolTipText("Can't add " + fishName + " because the fish is already added.\n");
			}else{
				fishButton.setToolTipText(m.canAddFishProblems(fishName));
			}
		}
*/
		fishButton.addActionListener(new fishButtonAction(m, fishName, this));
		this.add(fishButton);
	}
	
	public void setAddFishButton(){
		this.removeAll();
		this.add(addFishButton);
		revalidate();
		this.repaint();
		
		
	}
	
	public void setAddFishPanel(){
		this.remove(addFishButton);
		for (String fishName : m.getFishStrings())
		{
			addFish(fishName);
		}
		revalidate();
		this.repaint();
		
	}
}

class fishButtonAction extends AbstractAction
{
	Model m;
	String fishName;
	addFishPanel panel;

	fishButtonAction(Model m, String fishName, addFishPanel panel)
	{
		this.m = m;
		this.fishName = fishName;
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		m.addFishByString(fishName);
		panel.setAddFishButton();
	}
}
