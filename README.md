# Elderly-Monitoring-Application-Through-Human-Activity-Detection-System
The primary computer and communication tool in people's lives is quickly evolving to 
be their mobile phones or smartphones. In the field of ubiquitous computing, 
smartphones are being investigated as a potential alternative platform for human 
activity recognition. Strong sensors built into mobile devices include gyroscopes, 
magnetometers, GPS, accelerometers, proximity sensors, and ambient light detectors. 
Since they are frequently real-time in nature, smart sensors are better equipped than 
video streaming, according to their research from the previous year. Despite the fact 
that smartphone sensors are quite useful, performance analysis. Evidence indicating the 
raw data needs to be treated more technically to produce a favorable result. To avoid a 
performance and sensor data gap, we focused more on the usage of effective classifiers 
in our inquiry. These classifiers extract features from the data and separate it into trained 
and test data. Researchers have the chance to readily acquire sensor data with the usage 
of little infrastructure thanks to cellphones. Together, these sensors are opening up new 
possibilities in a range of industries, including healthcare, social media, security, and 
environmental monitoring.
The largest challenge is accurately classifying human activity based on the obtained 
data and collecting activity data through various wearable sensors. Based on the 
gathered data, modern machine learning algorithms can be utilized to detect and 
identify human behaviors. The issue of keeping a thorough record of a user's everyday 
activities could be resolved with the use of a straightforward smartphone. The ability 
to recognize human behaviors at deeper ontological levels may be pushed by 
developments in deep learning, feature selection techniques, and the use of a range of 
sensors
For an automatic activity monitoring project where the goal is to identify a certain 
movement or action of a person based on sensor data, we developed a system using 
sensor data. a device that can intelligently recognize whether a senior is active or 
passive, such as when they sit, walk, fall, etc. Through sensors, it provides an automated 
examination of human activity regardless of age (accelerometer, gyroscope, 
orientation). Due to its many uses in security, healthcare, surveillance, virtual reality, 
control systems, and automation, human activity detection has grown significantly in 
relevance. Modern mobile phones have sensors built in that allow for the discreet 
identification of activities of daily living (ADL). employing data mining techniques to 
preprocess samples that have been obtained. Two crucial phases in data preprocessing 
are data segmentation and data transformation. after assessing data on test samples, 
choosing a machine learning algorithm for classification. Knowing user activity, for 
example, makes it possible to communicate with them via an app that alerts caregivers 
when a fall is detected on their mobile device


## The goal of the project is to utilize mobile sensors for real-time activity detection of 
patients that are meant to be monitored. Such monitoring can be helpful in the early 
detection of dangerous activities such as falls to provide necessary help in time.
The project objectives are given below:
1. Preprocessing of collected samples using data mining techniques.
2. Select a classification algorithm for application after testing data on test
samples.
3. Provide an android application to monitor elderly patients' movement in realtime.
4. Provide notification on caregiver mobile in case of fall detection

   
## Implementation and Tools Details:
Google collab for (for model implementation)
Google collab using language (python)
Android studio (for making android app)
Android studio using language(java)
Flask (for model connect with app) tool used (PyCharm)
Flask Rest API 
API (volley) uses in android connect to sever and take prediction
Heroku (work as a sever for using this app)
Firebase (used for send notification)


## Functional Requirements:
NO Requirement Description
FR1 Trained Model integration: The model system works when the model 
takes data from the sensors then preprocess 
data, test and train splitting, decision tree 
algorithm is applied, trained the model then 
feature extraction and analysis after that 
evaluate the result.

FR2 Sensor Input: Appropriate accessing of sensors to obtain 
data for detection. Taking input from 
accelerometer, gyroscope and orientation.

FR3 Classification: Further a time delay in taking reading. Post 
request and taking response from server. It 
gives prediction then classify the activity. 
Fall based classification is determined.

FR4 Alarm: Generate alarm when sensors taking input. 
Its continuously generate alarm when sensor 
taking reading.

FR5 Send Notification: Send Notification to the receiver when an 
activity is taking place. If fall is detected then send notification


### Diagrams to understand Better

![hdur](https://github.com/SanaMQB/Elderly-Monitoring-Application-Through-Human-Activity-Detection-System/assets/139436888/77caad4c-fa78-46e2-88c8-39ae711ed80d)


![hdbue](https://github.com/SanaMQB/Elderly-Monitoring-Application-Through-Human-Activity-Detection-System/assets/139436888/360142d2-9cd9-4773-918c-81ac418a6fd4)


### Application Screenshots 

![jdkl](https://github.com/SanaMQB/Elderly-Monitoring-Application-Through-Human-Activity-Detection-System/assets/139436888/381423ab-e984-43f0-9b17-25de211289df)

### Notification
![md m](https://github.com/SanaMQB/Elderly-Monitoring-Application-Through-Human-Activity-Detection-System/assets/139436888/d5b5a881-1668-437e-bd2c-c4a5a313fde2)



## Conclusion:
We used a Human Activity Recognition System in this research. It is a programme that can identify actions taken by people. We evaluate the application's functional and nonfunctional needs. Then, to aid in a better understanding of implementation, we created a few architectures diagram classes and sequence diagrams. Following requirements and analysis, we provided a data set as input, using 80% of the data to train the model and the remaining 20% to test it. After being trained, the model recognises and identifies the activity occurring in the relevant sensor input. An algorithm for machine learning is used to train the model.
To build the model, extract the features, and analyse the activity, we employed the decision tree technique. It has a 90% accuracy rate. Embed the model in a mobile app to forecast fall activity simply and assist older patients right away when an alert notification appears. The use of smart phone sensors to identify activities opens up a wide range of potential research areas. Applications for smartphones that can detect user activity As a result, one only needs to install one application to watch activity in real time, as opposed to storing multiple remote controls in their cabinet. Because of the mobile activity recognition methodologies, it cross-field assists in saving time and preventing injuries.
## Future Work: 
It will take more research for HAD systems to realise their full potential. Since each study utilises a different dataset for activity identification, comparisons amongst HAD systems are hampered and eventually become unquantifiable. Researchers might benchmark their systems and improve the system as a whole with the use of a shared public dataset. Simple and atomic activities that have been identified in existing systems may be components of more complex composite behaviours. Context awareness can be improved by recognising composite actions. Additionally, there is a fantastic research opportunity to identify concurrent and overlapping activity. Extending the research on one-dimensional and two-dimensional convolutional neural networks and deep learning algorithms
To find out if hybrids of convolutional networks and LSTMs can handle the challenge of recognising human activity from raw signal data, more research should be done on them. Existing HAD systems are primarily focused on individual actions, but they might be further developed with the help of social networks to identify patterns and activity trends for a group of individuals. Lastly, action prediction systems for recognition
In some applications, the ability to predict user actions before they occur could be a revolutionary change. 
