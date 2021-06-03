import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.module.ModuleFinder;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private JTable table;
	
	public MainFrame() {
		super("Main Frame");
		
		setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		pack();
		setLocationRelativeTo(null);

//		initTable();

//		initListeners();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				String city = switch (row) {
					case 0 -> "Tehran";
					case 1 -> "Mashhad";
					case 2 -> "Rasht";
					case 3 -> "Shiraz";
					case 4 -> "Semnan";
					default -> "<none>";
				};
				
				JOptionPane.showMessageDialog(null, city, "City", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	
	private void initTable() {
		var model = new DefaultTableModel();
		model.addRow(new Object[]{"Tehran"});
		
		table.setModel(model);
	}
	
	private void createUIComponents() {
		String[] headers = {"State"};
		Object[][] data = {
				{"Tehran"},
				{"Khorasan Razavi"},
				{"Gilan"},
				{"Fars"},
				{"Semnan"},
		};
		
		table = new JTable(data, headers);
		table.setFillsViewportHeight(true);
	}
}
