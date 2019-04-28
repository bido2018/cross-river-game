package Level1Chars;

import View.LEVEL_1;
import View.start_page;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller implements IRiverCrossingController, java.io.Serializable {
    LEVEL_1 level_1;
    Strategy strategy1;
    start_page start_page;
    public Sprite x1; //farmer/
    public Sprite x2; //raft
    public Sprite x3; //goat
    public Sprite x4; //wolf
    public Sprite x5; //plant
    public Sprite x6;  // star
	public Controller() {
	}
	

	private ICrosser farmer = Farmer.getInstance();
    private ICrosser goat = Sheep.getInstance();
    private ICrosser wolf = Wolf.getInstance();
    private ICrosser plant = Plant.getInstance();

    boolean rowers = true;

    List<ICrosser> crossers = new ArrayList<>();
    List<ICrosser> LowerBankCrossers = new ArrayList<>();
    List<ICrosser> UpperBankCrossers = new ArrayList<>();

    public void clearcrossers(){
        this.crossers.clear();
    }
    public void setCrossers(List<ICrosser> crossers) {
        this.crossers = crossers;
    }

    public void setLowerBankCrossers(List<ICrosser> lowerBankCrossers) {
        this.LowerBankCrossers = lowerBankCrossers;
    }

    public void setUpperBankCrossers(List<ICrosser> upperBankCrossers) {
        this.UpperBankCrossers = upperBankCrossers;
    }


    public List<ICrosser> getCrossers() {
        return crossers;
    }

    public List<ICrosser> getLowerBankCrossers() {
        return LowerBankCrossers;
    }

    public List<ICrosser> getUpperBankCrossers() {
        return UpperBankCrossers;
    }
    
    public boolean success()
    {
    	System.out.println(UpperBankCrossers.size() + "   "  +LowerBankCrossers.size() + "   "+  crossers.size());
    	if(UpperBankCrossers.size() == 4 && LowerBankCrossers.size() == 0 && crossers.size() == 0)
    		return true;
    	else 
    		return false;
    }
    
    public int Ranking()
    {
    	int moves = level_1.getNumOfSails();
    	if(UpperBankCrossers.size() == 4 && LowerBankCrossers.size() == 0 && crossers.size() == 0)
    	{
    		if(moves == 7)
    			return 3;
    		else if(moves < 11)
    			return 2;
    		else
    			return 1;
    	}
    	else
    		return 0;
    }



    public Controller(LEVEL_1 level_1, Strategy strategy1, start_page start_page) {
        this.level_1 = level_1;
        this.strategy1 = strategy1;
        this.start_page = start_page;
    }
    public void Level1BuildScene(){
        level_1.scene_build();
    }
    public void MenuBuildScene(){
        start_page.scene_build();
    }
    public boolean CrosserOnRift(){
        if(crossers.size() <= 2)
            return true;
        else
            return false;
    }
    //*******************************************************************************************************
    public void setCrossersMovingUp(String crosser){

            if (crosser.equals("farmer")) {
                if(!crossers.contains(farmer)){
                    crossers.add(farmer);
                    UpperBankCrossers.add(farmer);
                    LowerBankCrossers.remove(farmer);
                }
            } else if (crosser.equals("goat")) {
                if(!crossers.contains(goat)) {
                    crossers.add(goat);
                    LowerBankCrossers.remove(goat);
                    UpperBankCrossers.add(goat);
                }
            } else if (crosser.equals("wolf")){
                if(!crossers.contains(wolf)) {
                    crossers.add(wolf);
                    LowerBankCrossers.remove(wolf);
                    UpperBankCrossers.add(wolf);
                }
            } else if (crosser.equals("plant")) {
                //if it doesnt exist add it
                if(!crossers.contains(plant)) {
                    crossers.add(plant);
                    LowerBankCrossers.remove(plant);
                    UpperBankCrossers.add(plant);
                }
            }
    }
    public void setCrossersMovingDown(String crosser){

        if (crosser.equals("farmer")) {
            if(!crossers.contains(farmer)){
                crossers.add(farmer);
                UpperBankCrossers.remove(farmer);
                LowerBankCrossers.add(farmer);
            }
        } else if (crosser.equals("goat")) {
            if(!crossers.contains(goat)) {
                crossers.add(goat);
                LowerBankCrossers.add(goat);
                UpperBankCrossers.remove(goat);
            }
        } else if (crosser.equals("wolf")){
            if(!crossers.contains(wolf)) {
                crossers.add(wolf);
                LowerBankCrossers.add(wolf);
                UpperBankCrossers.remove(wolf);
            }
        } else if (crosser.equals("plant")) {
            //if it doesnt exist add it
            if(!crossers.contains(plant)) {
                crossers.add(plant);
                LowerBankCrossers.add(plant);
                UpperBankCrossers.remove(plant);
            }
        }
    }
    //*******************************************************************************************************
    public void setLowerBankCrossers() {
    	if(LowerBankCrossers.size() != 0)
    		LowerBankCrossers.clear();
        LowerBankCrossers.add(farmer);
        LowerBankCrossers.add(goat);
        LowerBankCrossers.add(plant);
        LowerBankCrossers.add(wolf);
    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        setLowerBankCrossers();
        UpperBankCrossers.clear();
        crossers.clear();
    }

    @Override
    public void resetGame() {
        setLowerBankCrossers();
        UpperBankCrossers.clear();
        crossers.clear();
        
    }

    @Override
    public String[] getInstructions() {
        return new String[0];
    }

    @Override
    public List<ICrosser> getCrossersOnUpperBank() {
        return UpperBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLowerBank() {
        return LowerBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return level_1.getRiftLocation();
    }

    @Override
    public int getNumberOfSails() {
        return level_1.getNumOfSails();
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        boolean isvalid = strategy1.isValid(UpperBankCrossers, LowerBankCrossers, this.crossers);
        return isvalid;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLowerToUpperBank) {

    }

    @Override
    public boolean canUndo() {
        return false;
    }

    @Override
    public boolean canRedo() {
        return false;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
    
    @Override
    public void saveGame( 	Sprite farmer,Sprite raft,Sprite goat,Sprite wolf , Sprite plant ) {
		try {
		//	FileOutputStream filestream = new FileOutputStream(new File("./save_level1.xml"));
			XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(new File (("./save_level1.xml")))));
			
			encoder.writeObject(farmer);
			encoder.writeObject(raft);
			encoder.writeObject(goat);
			encoder.writeObject(wolf);
		    encoder.writeObject(plant);

            System.out.println("save is done");
			encoder.close();
			//filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("hi");
		}
		
    }
    
    public boolean check_load () {
    	FileInputStream file;
    	try {
			file = new FileInputStream (new File("./save_level1.xml"));
			if(file!=null)
	    		return true;
	    	else 
	    		return false;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return false;
    }
    
    @Override
    public  void   loadGame() {
    	FileInputStream file;
  		LowerBankCrossers.clear();
		UpperBankCrossers.clear();
		crossers.clear();
    	try {
    		System.out.println("**********************************");
    		file = new FileInputStream (new File("./save_level1.xml"));
    		XMLDecoder decoder = new XMLDecoder(file);
    		
    		
    		x1 = (Sprite) decoder.readObject();
    		x2= (Sprite) decoder.readObject();
    		x3= (Sprite) decoder.readObject();
    		x4 = (Sprite) decoder.readObject();
    		x5= (Sprite) decoder.readObject();
    		decoder.close();
    		
    		System.out.println("farmer location " + x1.getLocation());
    		System.out.println("goat location " + x3.getLocation());
    		System.out.println("wolf location " + x4.getLocation());
    		System.out.println("plant location " + x5.getLocation());
    		
    		//setting arrays of chars
    		if(x1.getLocation() == 1)
    			LowerBankCrossers.add(farmer);
    		else if(x1.getLocation() == 2) {
    			crossers.add(farmer);
    			UpperBankCrossers.add(farmer);
    		}
    		else if(x1.getLocation() == 3) {
    			crossers.add(farmer);
    			LowerBankCrossers.add(farmer);
    		}
    		else
    			UpperBankCrossers.add(farmer);
    		
    		if(x3.getLocation() == 1)
    			LowerBankCrossers.add(goat);
    		else if(x3.getLocation() == 2) {
    			crossers.add(goat);
    			UpperBankCrossers.add(goat);
    		}
    		else if(x3.getLocation() == 3) {
    			crossers.add(goat);
    			LowerBankCrossers.add(goat);
    		}
    		else
    			UpperBankCrossers.add(goat);
    		
    		if(x4.getLocation() == 1)
    			LowerBankCrossers.add(wolf);
    		else if(x4.getLocation() == 2) {
    			crossers.add(wolf);
    			UpperBankCrossers.add(wolf);
    		}
    		else if(x4.getLocation() == 3) {
    			crossers.add(wolf);
    			LowerBankCrossers.add(wolf);
    		}
    		else
    			UpperBankCrossers.add(wolf);
    		
    		if(x5.getLocation() == 1)
    			LowerBankCrossers.add(plant);
    		else if(x5.getLocation() == 2) {
    			crossers.add(plant);
    			UpperBankCrossers.add(plant);
    		}
    		else if(x5.getLocation() == 3) {
    			crossers.add(plant);
    			LowerBankCrossers.add(plant);
    		}
    		else
    			UpperBankCrossers.add(plant);
    		
    	//********************

    		
    		try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    	} catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }
	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	public void saveGame(Sprite resetbtn, Sprite savebtn, Sprite background, Sprite movebtn, Sprite farmer, Sprite raft,
			Sprite goat, Sprite wolf, Sprite plant) {
		// TODO Auto-generated method stub
		
	}
	
	public void saveGame(Sprite resetbtn, Sprite savebtn, Sprite background, Sprite movebtn, Sprite farmer, Sprite raft,
			Sprite goat, Sprite wolf, Sprite plant, Sprite loadbtn) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void loadGame(Sprite farmerload) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
