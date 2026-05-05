<html>
<head>
    <title>Fun Little Addition Quiz</title>
</head>
<body>
    <form action="QuizAnswers.jsp" method="post">
        <% 
        for (int i = 0; i < 10; i++) {
            int num1 = (int)(Math.random() * 100);
            int num2 = (int)(Math.random() * 10);
        %>
            <div>
                <%= num1 %> + <%= num2 %> = 
                <input type="number" name="answer<%= i %>" size="3" required>
                <input type="hidden" name="num1_<%= i %>" value="<%= num1 %>">
                <input type="hidden" name="num2_<%= i %>" value="<%= num2 %>">
            </div>
        <% } %>
        <br>
        <input type="submit" value="Submit">
        <span>Click Refresh For New Quiz</span>
    </form>
</body>
</html>