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

public class BarChart4 extends ApplicationFrame
{
	private int department[][];
   
   public BarChart4( String applicationTitle , String chartTitle, int dp[][] )
   {
      super( applicationTitle );        

      this.department = new int[4][2];
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
		for(int i = 0; i < 4; i++)
		{
		  if(department[i][0] == 1)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "safe and secure world" );        
			dataset.addValue( department[i][col] , "Acutal" , "safe and secure world" );
				col = 1;
		  }
		  else if(department[i][0] == 2)
		  {	  
			dataset.addValue( department[i][col++] , "Planned" , "Global poverty reduction" );        
			dataset.addValue( department[i][col] , "Acutal" , "Global poverty reduction" );
			col = 1;
		  }
		  else if(department[i][0] == 3)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "prosperous Canada" );        
			dataset.addValue( department[i][col] , "Acutal" , "prosperous Canada" ); 
			col = 1;
		  } 
		  else if(department[i][0] == 4)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "beneficial North American partnership" );        
			dataset.addValue( department[i][col] , "Acutal" , "beneficial North American partnership" ); 
			col = 1;
		  }
		}
	  }
	  else if(department[0][0] == 3)
	  {
			dataset.addValue( department[row][1] - department[row++][2], "Difference" , "safe and secure world" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "Global poverty reduction" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "prosperous Canada" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "beneficial North American partnership" );
			row = 0;
	  }             
	  else if(department[0][0] == 7)
	  {
			dataset.addValue( department[row][col++] , "Planned" , "safe and secure world" );        
			dataset.addValue( department[row++][col] , "Acutal" , "safe and secure world" );
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "Global poverty reduction" );        
			dataset.addValue( department[row++][col] , "Acutal" , "Global poverty reduction" );
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "prosperous Canada" );        
			dataset.addValue( department[row++][col] , "Acutal" , "prosperous Canada" ); 
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "beneficial North American partnership" );        
			dataset.addValue( department[row++][col] , "Acutal" , "beneficial North American partnership" ); 
			col = 1;
	  }
      return dataset; 
   }
   private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "2013-14 OutcomeArea - Planned and Actual Spending",       // chart title
            "International Affairs",               // domain axis label
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