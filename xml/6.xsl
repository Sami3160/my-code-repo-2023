<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="employees/employee">
                    <xsl:choose>
                        <xsl:when test="salary &lt; 40000">
                            <p>Low</p>
                            <br />
                        </xsl:when>

                        <xsl:when test="salary &lt; 60000">
                            <p>Medium</p>
                            <br />
                        </xsl:when>
                        <xsl:otherwise>
                            <p>High</p>
                            <br/>
                        </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>