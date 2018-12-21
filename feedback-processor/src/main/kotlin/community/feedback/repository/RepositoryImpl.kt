package community.feedback.repository

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.Item
import community.feedback.model.FeedbackRequest

class RepositoryImpl : Repository {

    val dynamoDbClient = AmazonDynamoDBClientBuilder
            .standard()
            .withRegion(Regions.EU_WEST_2)
            .build()

    val dynamoDb = DynamoDB(dynamoDbClient)

    override fun insertAttendance(feedbackRequest: FeedbackRequest) {
        println("Writing data")
        val table = dynamoDb.getTable("community-attendance")

        val json = """
            {
                "communityName": "${feedbackRequest.communityName}",
                "name": "${feedbackRequest.name}"
            }
        """.trimIndent()

        println(json)

        table.putItem(Item()
                .withPrimaryKey("communityName", feedbackRequest.communityName, "name", feedbackRequest.name)
        )

        println("Created Item")
    }
}