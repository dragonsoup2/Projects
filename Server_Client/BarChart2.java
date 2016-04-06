import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import java.awt.*;

public class BarChart2 extends ApplicationFrame
{
	private int department[][];
   
   public BarChart2( String applicationTitle , String chartTitle, int dp[][] )
   {
      super( applicationTitle );        

      this.department = new int[6][2];
	  this.department = dp;
	  CategoryDataset dataset = createDataset();
	  JFreeChart barChart = createChart(dataset);
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel );
   }
   private CategoryDataset createDataset( )
   {         
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
		int col = 1;
		int row = 0;
	  if(department[0][0] != 3 && department[0][0] != 7)
	  {
		for(int i = 0; i < 6; i++)
		{
		  if(department[i][0] == 1)
		  {
			  dataset.addValue( department[i][col++] , "Planned" , "Income security and employment" );        
			  dataset.addValue( department[i][col] , "Acutal" , "Income security and employment"); 
				col = 1;
		  }
		  else if(department[i][0] == 2)
		  {	  
			dataset.addValue( department[i][col++] , "Planned" , "Strong economic growth" );        
			dataset.addValue( department[i][col] , "Acutal" , "Strong economic growth" );	
			col = 1;
		  }
		  else if(department[i][0] == 3)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "innovative and knowledge" );        
			dataset.addValue( department[i][col] , "Acutal" , "innovative and knowledge" );
			col = 1;
		  } 
		  else if(department[i][0] == 4)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "clean and healthy environment" );        
			dataset.addValue( department[i][col] , "Acutal" , "clean and healthy environment" );              
			col = 1;
		  }
		  else if(department[i][0] == 5)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "fair and secure marketplace" );        
			dataset.addValue( department[i][col] , "Acutal" , "fair and secure marketplace" ); 
			col = 1;
		  }
		  else if(department[i][0] == 6)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "Other Expenditures" );        
			dataset.addValue( department[i][col] , "Acutal" , "Other Expenditures" );
			col = 1;
		  }		  
		}
	  }
	  else if(department[0][0] == 3)
	  {
			dataset.addValue( department[row][1] - department[row++][2], "Difference" , "Income security and employment" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "Strong economic growth" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "innovative and knowledge" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "clean and healthy environment" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "fair and secure marketplace" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "Other Expenditures" );
			row = 0;
	  }
	  else if(department[0][0] == 7)
	  {
			dataset.addValue( department[row][col++] , "Planned" , "Income security and employment" );        
			dataset.addValue( department[row++][col] , "Acutal" , "Income security and employment"); 
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "Strong economic growth" );        
			dataset.addValue( department[row++][col] , "Acutal" , "Strong economic growth" );	
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "innovative and knowledge" );        
			dataset.addValue( department[row++][col] , "Acutal" , "innovative and knowledge" );
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "clean and healthy environment" );        
			dataset.addValue( department[row++][col] , "Acutal" , "clean and healthy environment" );              
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "fair and secure marketplace" );        
			dataset.addValue( department[row++][col] , "Acutal" , "fair and secure marketplace" ); 
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "Other Expenditures" );        
			dataset.addValue( department[row++][col] , "Acutal" , "Other Expenditures" );
			col = 1;
	  }
	    
      return dataset; 
   }
   private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "2013-14 OutcomeArea - Planned and Actual Spending",       // chart title
            "Economic Affairs",               // domain axis label
            "Dollar ($)",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            false,                    // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setUpperMargin(0.15);
        
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
}