package test.target.interview;

import java.util.*;

public class Solution {
    final static int xMax = 400;
    final static int yMax = 600;
    public static void main(String [] args){

        int array[][] = new int[xMax][yMax];
        Scanner s = new Scanner(System.in);
        System.out.println(" Please enter number of barren island ");
        int n= s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String barrenString = s.nextLine();

            applyBarrenArea(array, barrenString);


        }

        //showContentsOfArray(array);

        List<Integer> farmingAreas = findFarmingAreas(array);

        farmingAreas.forEach(System.out::println);

    }

    public static List<Integer> findFarmingAreas(int[][] array) {
        int count = 1;
        List<Integer> farmingAreaList = new ArrayList<>();
        for (int j = 0; j < xMax ; j++) {
            for (int k = 0; k < yMax; k++) {
                if(array[j][k] == 0){
                    farmingAreaList.add(fillwithCount(array , j, k ,count , xMax, yMax ));
                    count++;
                }
            }
        }
        Collections.sort(farmingAreaList);
        return farmingAreaList;
    }

    public static void applyBarrenArea(int[][] array, String barrenString) {
        String barrenStr[] = barrenString.split(" ");
        int coord[] = new int[barrenStr.length];
        for (int j = 0; j < barrenStr.length; j++) {
            coord[j] = Integer.parseInt(barrenStr[j]);
        }
        for (int j = coord[0]; j <= coord[2]; j++) {
            for (int k = coord[1]; k <= coord[3]; k++) {
                array[j][k] = -1;
            }
        }
    }

    private static void showContentsOfArray(int[][] array) {
        for (int j = 0; j < xMax; j++) {
            for (int k = 0; k < yMax; k++) {
                System.out.print(array[j][k]+" ");
            }
            System.out.println();
        }
    }

    static  Set<Integer> testSet = new HashSet<Integer>();
    private static int fillwithCount(int[][] array, int x, int y, int count,int jMax,int kMax) {
        int returnVal =0;
        LinkedList<Coords>  coords= new LinkedList<>();
        coords.add(new Coords(x,y));
        while(coords.size()!=0) {
            Coords  current  = coords.poll();
            int j = current.getX();
            int k = current.getY();

            if(array[j][k] ==0 ){
                returnVal++;
                array[j][k] = count;
                if (j != 0 && array[j - 1][k] == 0) {
                    coords.add(new Coords(j-1,k));
                }
                if (j != (jMax - 1) && array[j + 1][k] == 0) {
                    coords.add(new Coords(j+1,k));

                }
                if (k != 0 && array[j][k - 1] == 0) {
                    coords.add(new Coords(j,k -1 ));
                }
                if (k != (kMax - 1) && array[j][k + 1] == 0) {
                    coords.add(new Coords(j,k+1 ));
                }
            }

        }
        return  returnVal;

    }
}
