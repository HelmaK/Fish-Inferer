import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class WaterPanel extends JPanel{
	public WaterPanel(Model m){
		SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        
        this.add(new JTextField("Temperature", 15));
        this.add(new JTextField("pH", 15));
        this.add(new JTextField("GH", 15));
        this.add(new JTextField("other param", 15));
		
	}
	
	
}