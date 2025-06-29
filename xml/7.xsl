<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" indent="yes"/>

  <xsl:template match="/">
    <html>
      <body>
        <h2>XPath Axes Examples</h2>

        <!-- Using child axis -->
        <h3>Child Axis (employee/name):</h3>
        <ul>
          <xsl:for-each select="company/employee/child::name">
            <li><xsl:value-of select="." /></li>
          </xsl:for-each>
        </ul>

        <h3>Parent Axis (of id  ):</h3>
        <ul>
          <xsl:for-each select="company/employee/child::name">
            <li>Name: <xsl:value-of select="." /></li>
          </xsl:for-each>
        </ul>


        <!-- Using parent axis -->
        <h3>Parent Axis (of name):</h3>
        <ul>
          <xsl:for-each select="company/employee/name">
            <li>Parent ID: <xsl:value-of select="parent::employee/@id" /></li>
          </xsl:for-each>
        </ul>


        <!-- Using preceding-sibling axis -->
        <h3>Preceding-sibling Axis (before employee with id='e3'):</h3>
        <ul>
          <xsl:for-each select="company/employee[@id='e3']/preceding-sibling::employee">
            <li><xsl:value-of select="name" /></li>
          </xsl:for-each>
        </ul>

        <!-- Using following-sibling axis -->
        <h3>Following-sibling Axis (after employee with id='e1'):</h3>
        <ul>
          <xsl:for-each select="company/employee[@id='e1']/following-sibling::employee">
            <li><xsl:value-of select="name" /></li>
          </xsl:for-each>
        </ul>

        <!-- Using self axis -->
        <h3>Self Axis (on employee with id='e2'):</h3>
        <ul>
          <xsl:for-each select="company/employee[@id='e2']/self::employee">
            <li>Self ID: <xsl:value-of select="@id" /> | Name: <xsl:value-of select="name"/></li>
          </xsl:for-each>
        </ul>

        <!-- Using attribute axis -->
        <h3>Attribute Axis (show all employee IDs):</h3>
        <ul>
          <xsl:for-each select="company/employee/attribute::id">
            <li><xsl:value-of select="." /></li>
          </xsl:for-each>
        </ul>

      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
