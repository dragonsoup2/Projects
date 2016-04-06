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

public class BarChart3 extends ApplicationFrame
{
	private int department[][];
   
   public BarChart3( String applicationTitle , String chartTitle, int dp[][] )
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
			dataset.addValue( department[i][col++] , "Planned" , "healthy Canadians" );        
			dataset.addValue( department[i][col] , "Acutal" , "healthy Canadians" ); 
				col = 1;
		  }
		  else if(department[i][0] == 2)
		  {	  
			dataset.addValue( department[i][col++] , "Planned" , "safe and secure Canada" );        
			dataset.addValue( department[i][col] , "Acutal" , "safe and secure Canada" );
			col = 1;
		  }
		  else if(department[i][0] == 3)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "diverse society" );        
			dataset.addValue( department[i][col] , "Acutal" , "diverse society" ); 
			col = 1;
		  } 
		  else if(department[i][0] == 4)
		  {
			dataset.addValue( department[i][col++] , "Planned" , "vibrant Canadian culture and heritage" );        
			dataset.addValue( department[i][col] , "Acutal" , "vibrant Canadian culture and heritage" ); 
			col = 1;
		  }
		}
	  }
	  else if(department[0][0] == 3)
	  {
			dataset.addValue( department[row][1] - department[row++][2], "Difference" , "healthy Canadians" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "safe and secure Canada" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "diverse society" );
			dataset.addValue( department[row][1] - department[row++][2] , "Difference" , "vibrant Canadian culture and heritage" );
			row = 0;
	  }
	  else if(department[0][0] == 7)
	  {
			dataset.addValue( department[row][col++] , "Planned" , "healthy Canadians" );        
			dataset.addValue( department[row++][col] , "Acutal" , "healthy Canadians" ); 
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "safe and secure Canada" );        
			dataset.addValue( department[row++][col] , "Acutal" , "safe and secure Canada" );
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "diverse society" );        
			dataset.addValue( department[row++][col] , "Acutal" , "diverse society" ); 
			col = 1;
			dataset.addValue( department[row][col++] , "Planned" , "vibrant Canadian culture and heritage" );        
			dataset.addValue( department[row++][col] , "Acutal" , "vibrant Canadian culture and heritage" ); 
			col = 1;
		}
      return dataset; 
   }
   private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "2013-14 OutcomeArea - Planned and Actual Spending",       // chart title
            "Social Affairs",               // domain axis label
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