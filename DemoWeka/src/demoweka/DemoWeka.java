/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demoweka;
import java.util.List;
 import weka.classifiers.Classifier;
 import weka.core.Instances;
 import weka.classifiers.Evaluation;
 import weka.classifiers.trees.J48;

/**
 *
 * @author tiendv
 */
public class DemoWeka {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        List<Object> listTrain=null; // nhớ truyền vào
        List<Object> listTest=null; // nhớ truyền vào
        // TODO code application logic here
        Instances train = BuildVector.buildVector(listTrain, 100); // Dữ liệu train
        Instances test =  BuildVector.buildVector(listTest, 50); // Dữ liệu Test
        // train classifier Gọi thuật toán phân lớp 
        
        Classifier cls = new J48(); //Gọi thuật toán phân lớp 
        cls.buildClassifier(train); //Build model đối với dữ liệu train
        
        // evaluate classifier and print some statistics
        Evaluation eval = new Evaluation(train); //Chạy đánh giá model xây dựng
        eval.evaluateModel(cls, test);
        System.out.println(eval.toSummaryString("\nResults\n======\n", false));
    }
}
