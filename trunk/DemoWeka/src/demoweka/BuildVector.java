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
    
     public static Instances buildVectorWithFeatures (int numberOfFeature, int numberofVector)
    {
        // numberOfFeature : Số các đặc trưng 
        // numberofVector : số các vector.
        
        Instances instances;
        // Value feature 
        FastVector vector = new FastVector(numberOfFeature+1);
        
        // Thêm ten cac dac trung
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
     
     public static Instances buildVector(List<Feature> feature, int numberofVector)
     {        
        Instances instancesData = buildVectorWithFeatures(numberofVector, feature.size());
        for(int i = 0; i < feature.size(); i++)
        {  
            Instance simple = insertFeatureValue(instancesData, feature.get(i), feature.size()+1);
            instancesData.add(simple);
        } 
        return instancesData;
     }
     
     public static Instance insertFeatureValue (Instances instancesData, Feature feature, int dimension )
     {
         Instance simple =  new SparseInstance(dimension);
         
         return simple;
     }
     
    
}
