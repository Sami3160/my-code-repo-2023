<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <p>Records in sorted order</p>
                <br />
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Salary</th>
                    </tr>
                    <xsl:for-each select="employees/employee">
                        <xsl:sort select="salary" data-type="text" order="descending" />
                        <tr>
                            <td>
                                <xsl:value-of select="id" />
                            </td>
                            <td>
                                <xsl:value-of select="name" />
                            </td>
                            <td>
                                <xsl:value-of select="department" />
                            </td>
                            <td>
                                <xsl:value-of select="salary" />
                            </td>
                        </tr>

                    </xsl:for-each>
                </table>
                <br />
                <br />
                <br />
                <p>Records over 60000 salary</p>
                <br />
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Salary</th>
                    </tr>
                    <xsl:for-each select="employees/employee">
                        <!-- <xsl:sort select="salary" data-type="text" order="ascending" /> -->
                        <xsl:if test="salary &gt; 60000">
                            <tr>
                                <td>
                                    <xsl:value-of select="id" />
                                </td>
                                <td>
                                    <xsl:value-of select="name" />
                                </td>
                                <td>
                                    <xsl:value-of select="department" />
                                </td>
                                <td>
                                    <xsl:value-of select="salary" />
                                </td>
                            </tr>
                        </xsl:if>

                    </xsl:for-each>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>