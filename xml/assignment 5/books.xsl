<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Book List</title>
                <style>
                       body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f0f2f5; 
    color: #333; 
    margin: 0;
    padding: 20px;
    line-height: 1.6;
}
h1 { 
    color: #2c3e50; 
    text-align: center;
    margin-bottom: 30px;
}
.book {
    background-color: #ffffff; 
    border: 1px solid #d1d9e6; 
    border-radius: 12px; 
    padding: 25px;
    margin: 20px auto; 
    box-shadow: 0 5px 15px rgba(0, 0, 0, 0.08); 
    max-width: 700px; 
}
.title {
    font-weight: 600; 
    font-size: 1.6em; 
    color: #1a5276; 
    margin-bottom: 10px;
}
.author {
    font-style: normal; 
    color: #566573; 
    font-size: 1.1em; 
}
                </style>
            </head>
            <body>
                <h1>Book List</h1>
                <xsl:for-each select="books/book">
                    <div class="book">
                        <div class="title"><xsl:value-of select="title"/></div>
                        <div class="author">by <xsl:value-of select="author"/></div>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
