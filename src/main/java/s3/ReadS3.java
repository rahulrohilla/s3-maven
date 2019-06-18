package s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadS3 {
    public static void main(String[] args) {


        String key_name = "aj.java";
        String bucket_name = "jjjmybucket112";

        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

        S3Object object = s3.getObject(new GetObjectRequest(bucket_name,key_name));

        InputStream objectData = object.getObjectContent();


        try{

            BufferedReader reader = new BufferedReader(new InputStreamReader(objectData));

            String line;

            while ((line = reader.readLine()) != null){

                System.out.println(line);

            }

            objectData.close();


        } catch (IOException e){

            e.printStackTrace();
        }

    }

}
