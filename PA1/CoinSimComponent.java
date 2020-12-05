import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.Color;

/**
   This component draws two car shapes.
*/
public class CoinSimComponent extends JComponent
{  
   CoinTossSimulator info;
   private static int VB = 30;
   private static int BAR_WIDTH = 50;
   public CoinSimComponent(CoinTossSimulator info){
      this.info = info;
   }
   public CoinSimComponent(){
   }
   public void paintComponent(Graphics g)
   {  
      int tallestBar = (this.info.getTwoHeads() > this.info.getTwoTails()? this.info.getTwoHeads() : this.info.getTwoTails()) > this.info.getHeadTails() ? (this.info.getTwoHeads() > this.info.getTwoTails()? this.info.getTwoHeads() : this.info.getTwoTails()): this.info.getHeadTails();
      
      double precentage =tallestBar*1.0/ this.info.getNumTrials();
      double scale = precentage*(getHeight() - 2 * VB)/(tallestBar * 1.0);
      
      int eachX = getWidth()/4;
      int bottom = getHeight() - VB;
      Graphics2D g2 = (Graphics2D) g;
      Bar bar1 = new Bar(bottom, eachX - BAR_WIDTH/2, this.BAR_WIDTH, this.info.getTwoHeads(),scale, new Color(255,0,0),"Two Heads: "+ String.valueOf(this.info.getTwoHeads())+" ("+String.valueOf(  (int) Math.round((this.info.getTwoHeads()*1.0/ this.info.getNumTrials())*100))+"%)");
      bar1.draw(g2);      
      Bar bar2 = new Bar(bottom, 2*eachX - BAR_WIDTH/2, this.BAR_WIDTH, this.info.getTwoTails(),scale, new Color(0,255,0),"Two Heads: "+ String.valueOf( this.info.getTwoTails())+" ("+String.valueOf( (int) Math.round((this.info.getTwoTails()*1.0/ this.info.getNumTrials())*100))+"%)");
      bar2.draw(g2);      
      Bar bar3 = new Bar(bottom, 3*eachX - BAR_WIDTH/2, this.BAR_WIDTH, this.info.getHeadTails(),scale, new Color(0,0,255),"Two Heads: "+ String.valueOf( this.info.getHeadTails())+" ("+String.valueOf( (int) Math.round((this.info.getHeadTails()*1.0/ this.info.getNumTrials())*100))+"%)");
      bar3.draw(g2);      
      
   }
}
