<html>
<head>
    <title>Funky Little Addition Quiz Answers</title>
</head>
<body>
    <%
    int correctCount = 0;
    for (int i = 0; i < 10; i++) {
        int num1 = Integer.parseInt(request.getParameter("num1_" + i));
        int num2 = Integer.parseInt(request.getParameter("num2_" + i));
        int userAnswer = Integer.parseInt(request.getParameter("answer" + i));
        int actualAnswer = num1 + num2;
        
        String result = (userAnswer == actualAnswer) ? "Right" : "Wrong";
        if (userAnswer == actualAnswer) {
            correctCount++;
        }
    %>
        <p><%= num1 %> + <%= num2 %> = <%= userAnswer %> **<%= result %>**</p>
    <% } %>
    
    <hr>
    <h3>The total questions you got correct is <%= correctCount %></h3>
    <a href="QuizQuestions.jsp">Take the quiz again</a>
</body>
</html>
