"""
SiteCertificate class to pull site certificate information for \
maitenance purposes

Operating command is: curl --insecure -v https://www.google.com 2>&1 \
| awk 'BEGIN { cert=0 } /^\* SSL connection/ { cert=1 } /^\*/ \
{ if (cert) print }'

Modules to import: PyCurl

SiteCertificate.py

Created 4/18/2019
Edited: Lloyd Dagoc
"""

import PyCurl


class SiteCertificate:
    """
    Utility class to pull site certificate information
    """

    def show_cert_summary(self, url):
        """
        Returns: String representation of the cert summary
        """

    def removeNonDigits(self, inventory):
        """
        Takes a dictionary and removes all non-numeric \
        key:value pairs from the dictionary
        so computation can be done
        Returns: a clean dictionary list
        """

        numInventory = {}
        numeric_types = [int, float, complex]

        for key, value in inventory.items():
            if type(value) in numeric_types:
                numInventory[str(key)] = value
        return numInventory

    def deleteZeros(self, inventory):
        """
        Takes a dictionary and removes all zero key:value pairs \
        from the dictionary so computation can be done
        Returns: a clean dictionary list
        """
        numInventory = {}
        for key, value in inventory.items():
            if value > 0:
                numInventory[str(key)] = value
        return numInventory

    def retain_numeric_only(self, gradeList):
        """
        Takes a list and removes all non-numeric types from the list
        so computation can be done
        Returns: a clean numeric list
        """
        numeric_types = [int, float, complex]
        gradeList = [i for i in gradeList if type(i) in numeric_types]
        return gradeList

    def retain_string_only(self, toFilterList):
        """
        Takes a list and retain string types from the list
        Returns: a clean string list
        """
        strTypes = [str]
        toFilterList = [i for i in toFilterList if type(i) in strTypes]
        return toFilterList
