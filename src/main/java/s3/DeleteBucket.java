package s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class DeleteBucket {

    public static void main(String[] args) {

        final AmazonS3 s3= AmazonS3ClientBuilder.defaultClient();

        String bucket_name= "jjjmybucket112";

        try{

            s3.deleteBucket(bucket_name);


        } catch (AmazonServiceException e){

            System.err.println("Amazon Service Error:: "+ e.getMessage());
        }
    }
}
