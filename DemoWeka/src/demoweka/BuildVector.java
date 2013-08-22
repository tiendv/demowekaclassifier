/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demoweka;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.filters.Filter;

/**
 *
 * @author tiendv
 */

public class BuildVector {

    /**
     * Buid cấu trúc của vector
     * @param numberOfFeature Số các đặc trưng
     * @param numberofVector số các vector.
     * @return 
     */
    public static Instances buildVectorWithFeatures (int numberOfFeature, int numberofVector)
    {
        Instances instances;
        // Value feature 
        FastVector vector = new FastVector(numberOfFeature+1);
        
        // Thêm tên cac dac trung để khi import giá trị từng đặc trưng vào sẽ thêm theo tên này
        // Gia su co n dac trung thi lam tuong tu features1,features2,features3,features4....
        Attribute features1 = new  Attribute("Dactrung1");
        vector.addElement(features1);
        Attribute features2 = new  Attribute("Dactrung2");
        vector.addElement(features2);
       
        //Cuối cùng tạo một đặc trưng để gán nhãn vector
        // Declare the class attribute along with its values
        FastVector classValue = new FastVector(2);
        classValue.addElement("same");
        classValue.addElement("diff");
        Attribute classAttribute = new Attribute("Class", classValue);
        vector.addElement(classAttribute);
        
        // Hoan thanh viec buld cai cau truc
        instances = new Instances("Name", vector,numberofVector);
        instances.setClassIndex(numberOfFeature);
        return instances;
    }
     // Xây dựng data
     /**
      * 
      * @param feature : Danh sách các đặc trưng và giá trị (số chiều và giá trị)
      * @param numberofVector : Số vector đưa vào train hoặc test
      * @return 
      */
     public static Instances buildVector(List<Feature> feature, int numberofVector)
     {    
        // Xây dựng cấu trúc của vector gồm bao nhiêu chiều có tên gì thuộc tính tên gi
        Instances instancesData = buildVectorWithFeatures(numberofVector, feature.size());
        
        for(int i = 0; i < feature.size(); i++)
        {  
            // Insert dữ liệu cho từng vector 
            Instance simple = insertFeatureValue(instancesData, feature.get(i), feature.size()+1);
            instancesData.add(simple);
        } 
        return instancesData;
     }
     
     /**
      * 
      * @param instancesData : Danh sách các vector
      * @param feature : Danh sách các đặc trưng và giá trị của mỗi đặc trưng 
      * @param dimension : Số chiều của vector (lưu ý là số các đặc trưng và 1 giá trị để gán nhãn nữa)
      * @return 
      */
     public static Instance insertFeatureValue (Instances instancesData, Feature feature, int dimension )
     {   
         Instance simple =  new SparseInstance(dimension);
         
         // Add các giá trị của các đặc trưng vào ( các giá trị theo các chiều trong vector) 
         // Bao gồm cả thuộc tính gán nhãn của vector.
         simple.setValue((Attribute) instancesData.attribute("Dactrung1"),feature.Value);
         
         // 
         return simple;
     }
}
