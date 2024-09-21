package dynamicprograming;

import java.util.ArrayList;
import java.util.List;

public class MagicCows {

    public static void main(String[] args) {
        int a;
        List<Integer> numberOfCowsOnEachFarm =
                List.of(1,2,1,2,1);
        List<TreeNode> nodes = new ArrayList<>();
        for(Integer numberOfCows : numberOfCowsOnEachFarm) {
            TreeNode treeNode = new TreeNode(numberOfCows, null, 0);
            nodes.add(treeNode);
        }
        List<Integer> visitingDays = List.of(0,1,2);

        solveProblem(2, nodes, List.of(0,1,2),0);

        System.out.println(nodes);
        System.out.println(nodes);


        int c = 8;
        int numberOfFarms = 4;
        int dayToQuery = 3;
        List<Integer> initialCowsOnEachFarm =  List.of(0, 1,2,3,1);

        int farmOfEachDay[][] = new int[dayToQuery+2][c+1];
        solution(c, initialCowsOnEachFarm, dayToQuery+1, farmOfEachDay);
        System.out.println();
    }

    public static int[][] solution(int maximumOfCowsInFarm,
                                List<Integer> initialCowsOnEachFarm,
                                int dayToQuery,
                                int farmOfEachDay[][]) {


        for(int i = 1; i < initialCowsOnEachFarm.size(); i++) {
            farmOfEachDay[0][initialCowsOnEachFarm.get(i)] += 1;
        }

        for(int day = 1;  day <= dayToQuery; day ++) {
            for(int cowsOnFarm = 1; cowsOnFarm < maximumOfCowsInFarm + 1; cowsOnFarm++) {
                if(farmOfEachDay[day-1][cowsOnFarm] == 0) {
                    continue;
                }
                if(cowsOnFarm * 2 > maximumOfCowsInFarm) {
                    farmOfEachDay[day][cowsOnFarm] += farmOfEachDay[day-1][cowsOnFarm] * 2 ;
                } else {
                    farmOfEachDay[day][cowsOnFarm*2] = farmOfEachDay[day-1][cowsOnFarm];
                }
            }
        }

        return farmOfEachDay;
    }

    public static void solveProblem(int maximumOfCows,
                                             List<TreeNode> farms,
                                             List<Integer> visitingDays,
                                             int currentDept) {
        if(currentDept == visitingDays.get(visitingDays.size() - 1)) {
            return ;
        }


        for(TreeNode farm : farms) {
            if(farm.getValue() + farm.getValue() > maximumOfCows) {
                TreeNode treeNode1 = new TreeNode(farm.getValue(), new ArrayList<>(), currentDept + 1);
                TreeNode treeNode2 = new TreeNode(farm.getValue(), new ArrayList<>(), currentDept + 1);
                farm.setChildren(List.of(treeNode1, treeNode2));
                solveProblem(maximumOfCows, farm.getChildren(), visitingDays, currentDept + 1);
            } else {
                TreeNode child = new TreeNode(farm.getValue() * 2, new ArrayList<>(), currentDept + 1);
                farm.setChildren(List.of(child));
                solveProblem(maximumOfCows, List.of(child), visitingDays, currentDept + 1);
            }
        }

        return ;
    }
}

class TreeNode {
    private Integer value;
    private List<TreeNode> children;
    private int dept = 0;

    public TreeNode() {
    }

    public TreeNode(Integer value, List<TreeNode> children, int dept) {
        this.value = value;
        this.children = children;
        this.dept = dept;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }
}
