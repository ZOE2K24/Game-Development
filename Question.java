public class Question {
    private String question;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String fourthAnswer;
    private String correctAnswer;

    public Question(String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, String correctAnswer) {
        super();
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.correctAnswer = correctAnswer;
    }
    /// Question ob1 = new Question(str1, str2, str3, str4, str5, str6);
    
    // return getQuestion();
    // getter for Question
    // Getter for question
    public String getQuestion() {
        return question;
    }

    // Setter for question
    public void setQuestion(String question) {
        this.question = question;
    }

    // Getter for firstAnswer
    public String getFirstAnswer() {
        return firstAnswer;
    }

    // Setter for firstAnswer
    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    // Getter for secondAnswer
    public String getSecondAnswer() {
        return secondAnswer;
    }

    // Setter for secondAnswer
    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    // Getter for thirdAnswer
    public String getThirdAnswer() {
        return thirdAnswer;
    }

    // Setter for thirdAnswer
    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    // Getter for fourthAnswer
    public String getFourthAnswer() {
        return fourthAnswer;
    }

    // Setter for fourthAnswer
    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    // Getter for correctAnswer
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Setter for correctAnswer
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return question + "\n" + firstAnswer + "\n" + secondAnswer + "\n" + thirdAnswer + "\n" + fourthAnswer;
    }
}