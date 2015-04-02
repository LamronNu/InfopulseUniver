<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:tparams = "http://aaa.com/bbb">
    <xsl:template match="/">
        <html>
            <body>
                <table>
                    <tr>
                        <th>id</th>
                        <th>name</th>
                        <th>origin</th>
                        <th>price</th>
                        <th>peripheral</th>
                    </tr>
                    <xsl:for-each select="devices/device">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td><xsl:value-of select="price"/></td>
                            <td><xsl:value-of select="type/tparams:peripheral"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>