Link to GitHub repository: https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App

Link to Youtube Video: 

App Report: 1. App Objective
QuizTech is an Android learning app utilizing IT quizzes built on the Kotlin platform. The purpose of these questions-for-the-user is to test the basic knowledge of computers and information technology through interactive, picture-based True/False questions.

Key Objectives: Provide a fun and engaging atmosphere for IT knowledge self-assessment. 
Serve arbitrary questions to create a fun quiz. 
Offer instant feedback along with options to retry or see the marks. 
Leverage question images as a visual learning technique.

2. Design Factors
a. Structure of the App
There are four main activities in the app, each linked to specific responsibilities:

Main Activity: The navigation menus appear on the main screen.
MainActivity2: The main screen of the quiz interface where users attempt the questions.
Main Activity 3: Shows the comments and final marks.
Main Activity 4: Go through and correct the questions that were attempted.

This modularized approach allows greater maintenance and separation of concerns.

b. Interface (UI)
Designed with the mobile user in mind, the user interface will be straightforward. 
Android UI Components like ImageView, TextView, and Button were used in creating this responsive UI.
The WindowInsetsCompat allows for edge-to-edge window management with proper padding. 
The design was created to be accessible, considering buttons and instructions that are properly captioned.

c. Features of User Experience (UX)
Randomized Quiz Flow: Five questions get picked randomly out of twenty, so there is a pretty unique experience every time.
Recall is increased while excitement ensues by using image-based questions as visual cues.
Answer Feedback: Real-time feedback after each response can help cement learning.
Score Display & Motivation: Depending on the user's score, encouraging messages are shown.
Retry and Correction Features: Enable users to practice with questions from which they answered incorrectly and retake the quiz.

d. Reasoning and Usability
Questions get shuffled and indexed by the shuffled() method and a custom list called questionOrder found on Android.
Each response is verified as to whether it matches that of the user and is stored in a BooleanArray.
To avoid multiple inputs or accidental navigation, UI controls get enabled or disabled depending on context.
Navigating from one Activity to another is handled via Intents, passing relevant data (such as scores) via putExtra.

e. Best Practices and Performance
Asset references are scalable using getIdentifier() to load images dynamically.
FinishAffinity() and exitProcess(1) are used to close down the app.
Kotlin guidelines have been followed with clean function separation (startQuiz, checkAns, nextQuestion, etc.).
Real-time resource management and low memory consumption assure compatibility with almost all Android devices.

3. In Conclusion
QuizTech is a well-crafted Android application using Kotlin and the Android SDK to give out an entertaining and educational quiz experience. Thanks to its well-thought-out organization, modular architecture, and user-friendly UI, the app provides users with strong means to evaluate and enhance their fundamental knowledge of IT. With the help of score recall, random question supply, and correction navigation options, it turns into a tool for learning as well as an enjoyable mobile experience.y

Images and Screenshots from app: 
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot1.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot2.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot3.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot4.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot5.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot6.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot7.png)
![image alt](https://github.com/ST10477696-Hloniphani/The-Quiz-Tech-App/blob/534b343fca604b0afe6cf64d0aea76b336d5e95a/screenshot8.png)
