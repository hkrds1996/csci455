import javax.swing.JFrame;

public class CoinSimViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(800, 500);
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      CoinTossSimulator info = new CoinTossSimulator();
      info.run(Integer.MAX_VALUE );
      CoinSimComponent component = new CoinSimComponent(info);
      frame.add(component);
      frame.setVisible(true);      
   }
}
