// AP computer science A
// 2020 free response question

// state solution

/*
* ArrayList solution
* ArrayList to keep the hisotry of spinning instead of state, better in that:
* 1. current run
* 2. replay history
*/
public class Spinner {

    private int numSectors; // sectors from  1, 2, ...
    private int lastSpinResult;// defualt 0, not on any sector
    private int lengthOfLastRun;
    private int currentSpinResult;
    
    public Spinner(int numSectors)
    {
      if (numSectors < 3)
      {
        throw new IllegalArgumentException("Minimum 3 sectors");
      }
      this.numSectors = numSectors;
    }
    
    public int spin()
    {
      //
      lastSpinResult = currentSpinResult;

      currentSpinResult = (int) (Math.random() * numSectors);
      if(currentSpinResult == 0)
      {
        currentSpinResult = 1;
      }
      
      lengthOfLastRun = getCurrentRun();
      return currentSpinResult;
    }
    
    public int getCurrentRun()
    { 
        int lengthOfCurrentRun = lengthOfLastRun;

      if(lastSpinResult == 0 && currentSpinResult == 0)
      {
        lengthOfCurrentRun = 0;
        return 0;
      }
      else
      {
        if(currentSpinResult == lastSpinResult)
        {
            lengthOfCurrentRun++;
        }
        else
        {
            lengthOfCurrentRun = 1;
        }
      }
      return lengthOfCurrentRun;
    }    

  public static void main(String args[]) {

    Spinner s = new Spinner(4);
    System.out.println("currentRun()    " + s.lengthOfLastRun);
    s.spin();
    System.out.println("spin()    " + s.currentSpinResult);
    System.out.println("currentRun()    " + s.lengthOfLastRun);

    s.spin();
    System.out.println("spin()    " + s.currentSpinResult);
    System.out.println("currentRun()    " + s.lengthOfLastRun);

    s.spin();
    System.out.println("spin()    " + s.currentSpinResult);
    System.out.println("currentRun()    " + s.lengthOfLastRun); 
    
    s.spin();
    System.out.println("spin()    " + s.currentSpinResult);
    System.out.println("currentRun()    " + s.lengthOfLastRun);    
  }
}
