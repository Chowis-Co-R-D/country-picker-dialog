package com.chowis.country_phone_code_picker_dialog

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.chowis.country_picker_dialog.CountryPickerDialog
import com.chowis.country_picker_dialog.model.Country
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    val json = """[
        {
            "id": 1,
            "name": "Andorra",
            "phone_code": "376",
            "country_code": "AD"
        },
        {
            "id": 2,
            "name": "United Arab Emirates",
            "phone_code": "971",
            "country_code": "AE"
        },
        {
            "id": 3,
            "name": "Afghanistan",
            "phone_code": "93",
            "country_code": "AF"
        },
        {
            "id": 4,
            "name": "Antigua and Barbuda",
            "phone_code": "1-268",
            "country_code": "AG"
        },
        {
            "id": 5,
            "name": "Anguilla",
            "phone_code": "1-264",
            "country_code": "AI"
        },
        {
            "id": 6,
            "name": "Albania",
            "phone_code": "355",
            "country_code": "AL"
        },
        {
            "id": 7,
            "name": "Armenia",
            "phone_code": "374",
            "country_code": "AM"
        },
        {
            "id": 8,
            "name": "Angola",
            "phone_code": "244",
            "country_code": "AO"
        },
        {
            "id": 9,
            "name": "Antarctica",
            "phone_code": "672",
            "country_code": "AQ"
        },
        {
            "id": 10,
            "name": "Argentina",
            "phone_code": "54",
            "country_code": "AR"
        },
        {
            "id": 11,
            "name": "American Samoa",
            "phone_code": "1-684",
            "country_code": "AS"
        },
        {
            "id": 12,
            "name": "Austria",
            "phone_code": "43",
            "country_code": "AT"
        },
        {
            "id": 13,
            "name": "Australia",
            "phone_code": "61",
            "country_code": "AU"
        },
        {
            "id": 14,
            "name": "Aruba",
            "phone_code": "297",
            "country_code": "AW"
        },
        {
            "id": 15,
            "name": "Åland Islands",
            "phone_code": "358",
            "country_code": "AX"
        },
        {
            "id": 16,
            "name": "Azerbaijan",
            "phone_code": "994",
            "country_code": "AZ"
        },
        {
            "id": 17,
            "name": "Bosnia and Herzegovina",
            "phone_code": "387",
            "country_code": "BA"
        },
        {
            "id": 18,
            "name": "Barbados",
            "phone_code": "1-246",
            "country_code": "BB"
        },
        {
            "id": 19,
            "name": "Bangladesh",
            "phone_code": "880",
            "country_code": "BD"
        },
        {
            "id": 20,
            "name": "Belgium",
            "phone_code": "32",
            "country_code": "BE"
        },
        {
            "id": 21,
            "name": "Burkina Faso",
            "phone_code": "226",
            "country_code": "BF"
        },
        {
            "id": 22,
            "name": "Bulgaria",
            "phone_code": "359",
            "country_code": "BG"
        },
        {
            "id": 23,
            "name": "Bahrain",
            "phone_code": "973",
            "country_code": "BH"
        },
        {
            "id": 24,
            "name": "Burundi",
            "phone_code": "257",
            "country_code": "BI"
        },
        {
            "id": 25,
            "name": "Benin",
            "phone_code": "229",
            "country_code": "BJ"
        },
        {
            "id": 26,
            "name": "Saint Barthélemy",
            "phone_code": "590",
            "country_code": "BL"
        },
        {
            "id": 27,
            "name": "Bermuda",
            "phone_code": "1-441",
            "country_code": "BM"
        },
        {
            "id": 28,
            "name": "Brunei Darussalam",
            "phone_code": "673",
            "country_code": "BN"
        },
        {
            "id": 29,
            "name": "Bolivia (Plurinational State of)",
            "phone_code": "591",
            "country_code": "BO"
        },
        {
            "id": 30,
            "name": "Bonaire, Sint Eustatius and Saba",
            "phone_code": "599",
            "country_code": "BQ"
        },
        {
            "id": 31,
            "name": "Brazil",
            "phone_code": "55",
            "country_code": "BR"
        },
        {
            "id": 32,
            "name": "Bahamas",
            "phone_code": "1-242",
            "country_code": "BS"
        },
        {
            "id": 33,
            "name": "Bhutan",
            "phone_code": "975",
            "country_code": "BT"
        },
        {
            "id": 34,
            "name": "Bouvet Island",
            "phone_code": "47",
            "country_code": "BV"
        },
        {
            "id": 35,
            "name": "Botswana",
            "phone_code": "267",
            "country_code": "BW"
        },
        {
            "id": 36,
            "name": "Belarus",
            "phone_code": "375",
            "country_code": "BY"
        },
        {
            "id": 37,
            "name": "Belize",
            "phone_code": "501",
            "country_code": "BZ"
        },
        {
            "id": 38,
            "name": "Canada",
            "phone_code": "1",
            "country_code": "CA"
        },
        {
            "id": 39,
            "name": "Cocos (Keeling) Islands",
            "phone_code": "61",
            "country_code": "CC"
        },
        {
            "id": 40,
            "name": "Congo, Democratic Republic of the",
            "phone_code": "243",
            "country_code": "CD"
        },
        {
            "id": 41,
            "name": "Central African Republic",
            "phone_code": "236",
            "country_code": "CF"
        },
        {
            "id": 42,
            "name": "Congo",
            "phone_code": "242",
            "country_code": "CG"
        },
        {
            "id": 43,
            "name": "Switzerland",
            "phone_code": "41",
            "country_code": "CH"
        },
        {
            "id": 44,
            "name": "Côte d'Ivoire",
            "phone_code": "225",
            "country_code": "CI"
        },
        {
            "id": 45,
            "name": "Cook Islands",
            "phone_code": "682",
            "country_code": "CK"
        },
        {
            "id": 46,
            "name": "Chile",
            "phone_code": "56",
            "country_code": "CL"
        },
        {
            "id": 47,
            "name": "Cameroon",
            "phone_code": "237",
            "country_code": "CM"
        },
        {
            "id": 48,
            "name": "China",
            "phone_code": "86",
            "country_code": "CN"
        },
        {
            "id": 49,
            "name": "Colombia",
            "phone_code": "57",
            "country_code": "CO"
        },
        {
            "id": 50,
            "name": "Costa Rica",
            "phone_code": "506",
            "country_code": "CR"
        },
        {
            "id": 51,
            "name": "Cuba",
            "phone_code": "53",
            "country_code": "CU"
        },
        {
            "id": 52,
            "name": "Cabo Verde",
            "phone_code": "238",
            "country_code": "CV"
        },
        {
            "id": 53,
            "name": "Curaçao",
            "phone_code": "599",
            "country_code": "CW"
        },
        {
            "id": 54,
            "name": "Christmas Island",
            "phone_code": "61",
            "country_code": "CX"
        },
        {
            "id": 55,
            "name": "Cyprus",
            "phone_code": "357",
            "country_code": "CY"
        },
        {
            "id": 56,
            "name": "Czechia",
            "phone_code": "420",
            "country_code": "CZ"
        },
        {
            "id": 57,
            "name": "Germany",
            "phone_code": "49",
            "country_code": "DE"
        },
        {
            "id": 58,
            "name": "Djibouti",
            "phone_code": "253",
            "country_code": "DJ"
        },
        {
            "id": 59,
            "name": "Denmark",
            "phone_code": "45",
            "country_code": "DK"
        },
        {
            "id": 60,
            "name": "Dominica",
            "phone_code": "1-767",
            "country_code": "DM"
        },
        {
            "id": 61,
            "name": "Dominican Republic",
            "phone_code": "1-849",
            "country_code": "DO"
        },
        {
            "id": 62,
            "name": "Algeria",
            "phone_code": "213",
            "country_code": "DZ"
        },
        {
            "id": 63,
            "name": "Ecuador",
            "phone_code": "593",
            "country_code": "EC"
        },
        {
            "id": 64,
            "name": "Estonia",
            "phone_code": "372",
            "country_code": "EE"
        },
        {
            "id": 65,
            "name": "Egypt",
            "phone_code": "20",
            "country_code": "EG"
        },
        {
            "id": 66,
            "name": "Western Sahara",
            "phone_code": "212",
            "country_code": "EH"
        },
        {
            "id": 67,
            "name": "Eritrea",
            "phone_code": "291",
            "country_code": "ER"
        },
        {
            "id": 68,
            "name": "Spain",
            "phone_code": "34",
            "country_code": "ES"
        },
        {
            "id": 69,
            "name": "Ethiopia",
            "phone_code": "251",
            "country_code": "ET"
        },
        {
            "id": 70,
            "name": "Finland",
            "phone_code": "358",
            "country_code": "FI"
        },
        {
            "id": 71,
            "name": "Fiji",
            "phone_code": "679",
            "country_code": "FJ"
        },
        {
            "id": 72,
            "name": "Falkland Islands (Malvinas)",
            "phone_code": "500",
            "country_code": "FK"
        },
        {
            "id": 73,
            "name": "Micronesia (Federated States of)",
            "phone_code": "691",
            "country_code": "FM"
        },
        {
            "id": 74,
            "name": "Faroe Islands",
            "phone_code": "298",
            "country_code": "FO"
        },
        {
            "id": 75,
            "name": "France",
            "phone_code": "33",
            "country_code": "FR"
        },
        {
            "id": 76,
            "name": "Gabon",
            "phone_code": "241",
            "country_code": "GA"
        },
        {
            "id": 77,
            "name": "United Kingdom of Great Britain and Northern Ireland",
            "phone_code": "44",
            "country_code": "GB"
        },
        {
            "id": 78,
            "name": "Grenada",
            "phone_code": "1-473",
            "country_code": "GD"
        },
        {
            "id": 79,
            "name": "Georgia",
            "phone_code": "995",
            "country_code": "GE"
        },
        {
            "id": 80,
            "name": "French Guiana",
            "phone_code": "594",
            "country_code": "GF"
        },
        {
            "id": 81,
            "name": "Ghana",
            "phone_code": "233",
            "country_code": "GH"
        },
        {
            "id": 82,
            "name": "Gibraltar",
            "phone_code": "350",
            "country_code": "GI"
        },
        {
            "id": 83,
            "name": "Greenland",
            "phone_code": "299",
            "country_code": "GL"
        },
        {
            "id": 84,
            "name": "Gambia",
            "phone_code": "220",
            "country_code": "GM"
        },
        {
            "id": 85,
            "name": "Guinea",
            "phone_code": "224",
            "country_code": "GN"
        },
        {
            "id": 86,
            "name": "Guadeloupe",
            "phone_code": "590",
            "country_code": "GP"
        },
        {
            "id": 87,
            "name": "Equatorial Guinea",
            "phone_code": "240",
            "country_code": "GQ"
        },
        {
            "id": 88,
            "name": "Greece",
            "phone_code": "30",
            "country_code": "GR"
        },
        {
            "id": 89,
            "name": "South Georgia and the South Sandwich Islands",
            "phone_code": "500",
            "country_code": "GS"
        },
        {
            "id": 90,
            "name": "Guatemala",
            "phone_code": "502",
            "country_code": "GT"
        },
        {
            "id": 91,
            "name": "Guam",
            "phone_code": "1-671",
            "country_code": "GU"
        },
        {
            "id": 92,
            "name": "Guinea-Bissau",
            "phone_code": "245",
            "country_code": "GW"
        },
        {
            "id": 93,
            "name": "Guyana",
            "phone_code": "592",
            "country_code": "GY"
        },
        {
            "id": 94,
            "name": "Hong Kong",
            "phone_code": "852",
            "country_code": "HK"
        },
        {
            "id": 95,
            "name": "Heard Island and McDonald Islands",
            "phone_code": "61",
            "country_code": "HM"
        },
        {
            "id": 96,
            "name": "Honduras",
            "phone_code": "504",
            "country_code": "HN"
        },
        {
            "id": 97,
            "name": "Croatia",
            "phone_code": "385",
            "country_code": "HR"
        },
        {
            "id": 98,
            "name": "Haiti",
            "phone_code": "509",
            "country_code": "HT"
        },
        {
            "id": 99,
            "name": "Hungary",
            "phone_code": "36",
            "country_code": "HU"
        },
        {
            "id": 100,
            "name": "Indonesia",
            "phone_code": "62",
            "country_code": "ID"
        },
        {
            "id": 101,
            "name": "Ireland",
            "phone_code": "353",
            "country_code": "IE"
        },
        {
            "id": 102,
            "name": "Israel",
            "phone_code": "972",
            "country_code": "IL"
        },
        {
            "id": 103,
            "name": "India",
            "phone_code": "91",
            "country_code": "IN"
        },
        {
            "id": 104,
            "name": "British Indian Ocean Territory",
            "phone_code": "246",
            "country_code": "IO"
        },
        {
            "id": 105,
            "name": "Iraq",
            "phone_code": "964",
            "country_code": "IQ"
        },
        {
            "id": 106,
            "name": "Iran (Islamic Republic of)",
            "phone_code": "98",
            "country_code": "IR"
        },
        {
            "id": 107,
            "name": "Iceland",
            "phone_code": "354",
            "country_code": "IS"
        },
        {
            "id": 108,
            "name": "Italy",
            "phone_code": "39",
            "country_code": "IT"
        },
        {
            "id": 109,
            "name": "Jamaica",
            "phone_code": "1-876",
            "country_code": "JM"
        },
        {
            "id": 110,
            "name": "Jordan",
            "phone_code": "962",
            "country_code": "JO"
        },
        {
            "id": 111,
            "name": "Japan",
            "phone_code": "81",
            "country_code": "JP"
        },
        {
            "id": 112,
            "name": "Kenya",
            "phone_code": "254",
            "country_code": "KE"
        },
        {
            "id": 113,
            "name": "Kyrgyzstan",
            "phone_code": "996",
            "country_code": "KG"
        },
        {
            "id": 114,
            "name": "Cambodia",
            "phone_code": "855",
            "country_code": "KH"
        },
        {
            "id": 115,
            "name": "Kiribati",
            "phone_code": "686",
            "country_code": "KI"
        },
        {
            "id": 116,
            "name": "Comoros",
            "phone_code": "269",
            "country_code": "KM"
        },
        {
            "id": 117,
            "name": "Saint Kitts and Nevis",
            "phone_code": "1-869",
            "country_code": "KN"
        },
        {
            "id": 118,
            "name": "Korea (Democratic People's Republic of)",
            "phone_code": "850",
            "country_code": "KP"
        },
        {
            "id": 119,
            "name": "Korea, Republic of",
            "phone_code": "82",
            "country_code": "KR"
        },
        {
            "id": 120,
            "name": "Kuwait",
            "phone_code": "965",
            "country_code": "KW"
        },
        {
            "id": 121,
            "name": "Cayman Islands",
            "phone_code": "1-345",
            "country_code": "KY"
        },
        {
            "id": 122,
            "name": "Kazakhstan",
            "phone_code": "7",
            "country_code": "KZ"
        },
        {
            "id": 123,
            "name": "Lao People's Democratic Republic",
            "phone_code": "856",
            "country_code": "LA"
        },
        {
            "id": 124,
            "name": "Lebanon",
            "phone_code": "961",
            "country_code": "LB"
        },
        {
            "id": 125,
            "name": "Saint Lucia",
            "phone_code": "1-758",
            "country_code": "LC"
        },
        {
            "id": 126,
            "name": "Liechtenstein",
            "phone_code": "423",
            "country_code": "LI"
        },
        {
            "id": 127,
            "name": "Sri Lanka",
            "phone_code": "94",
            "country_code": "LK"
        },
        {
            "id": 128,
            "name": "Liberia",
            "phone_code": "231",
            "country_code": "LR"
        },
        {
            "id": 129,
            "name": "Lesotho",
            "phone_code": "266",
            "country_code": "LS"
        },
        {
            "id": 130,
            "name": "Lithuania",
            "phone_code": "370",
            "country_code": "LT"
        },
        {
            "id": 131,
            "name": "Luxembourg",
            "phone_code": "352",
            "country_code": "LU"
        },
        {
            "id": 132,
            "name": "Latvia",
            "phone_code": "371",
            "country_code": "LV"
        },
        {
            "id": 133,
            "name": "Libya",
            "phone_code": "218",
            "country_code": "LY"
        },
        {
            "id": 134,
            "name": "Morocco",
            "phone_code": "212",
            "country_code": "MA"
        },
        {
            "id": 135,
            "name": "Monaco",
            "phone_code": "377",
            "country_code": "MC"
        },
        {
            "id": 136,
            "name": "Moldova, Republic of",
            "phone_code": "373",
            "country_code": "MD"
        },
        {
            "id": 137,
            "name": "Montenegro",
            "phone_code": "382",
            "country_code": "ME"
        },
        {
            "id": 138,
            "name": "Saint Martin (French part)",
            "phone_code": "590",
            "country_code": "MF"
        },
        {
            "id": 139,
            "name": "Madagascar",
            "phone_code": "261",
            "country_code": "MG"
        },
        {
            "id": 140,
            "name": "Marshall Islands",
            "phone_code": "692",
            "country_code": "MH"
        },
        {
            "id": 141,
            "name": "North Macedonia",
            "phone_code": "389",
            "country_code": "MK"
        },
        {
            "id": 142,
            "name": "Mali",
            "phone_code": "223",
            "country_code": "ML"
        },
        {
            "id": 143,
            "name": "Myanmar",
            "phone_code": "95",
            "country_code": "MM"
        },
        {
            "id": 144,
            "name": "Mongolia",
            "phone_code": "976",
            "country_code": "MN"
        },
        {
            "id": 145,
            "name": "Macao",
            "phone_code": "853",
            "country_code": "MO"
        },
        {
            "id": 146,
            "name": "Northern Mariana Islands",
            "phone_code": "1-670",
            "country_code": "MP"
        },
        {
            "id": 147,
            "name": "Martinique",
            "phone_code": "596",
            "country_code": "MQ"
        },
        {
            "id": 148,
            "name": "Mauritania",
            "phone_code": "222",
            "country_code": "MR"
        },
        {
            "id": 149,
            "name": "Montserrat",
            "phone_code": "1-664",
            "country_code": "MS"
        },
        {
            "id": 150,
            "name": "Malta",
            "phone_code": "356",
            "country_code": "MT"
        },
        {
            "id": 151,
            "name": "Mauritius",
            "phone_code": "230",
            "country_code": "MU"
        },
        {
            "id": 152,
            "name": "Maldives",
            "phone_code": "960",
            "country_code": "MV"
        },
        {
            "id": 153,
            "name": "Malawi",
            "phone_code": "265",
            "country_code": "MW"
        },
        {
            "id": 154,
            "name": "Mexico",
            "phone_code": "52",
            "country_code": "MX"
        },
        {
            "id": 155,
            "name": "Malaysia",
            "phone_code": "60",
            "country_code": "MY"
        },
        {
            "id": 156,
            "name": "Mozambique",
            "phone_code": "258",
            "country_code": "MZ"
        },
        {
            "id": 157,
            "name": "New Caledonia",
            "phone_code": "687",
            "country_code": "NC"
        },
        {
            "id": 158,
            "name": "Niger",
            "phone_code": "227",
            "country_code": "NE"
        },
        {
            "id": 159,
            "name": "Norfolk Island",
            "phone_code": "672",
            "country_code": "NF"
        },
        {
            "id": 160,
            "name": "Nigeria",
            "phone_code": "234",
            "country_code": "NG"
        },
        {
            "id": 161,
            "name": "Nicaragua",
            "phone_code": "505",
            "country_code": "NI"
        },
        {
            "id": 162,
            "name": "Netherlands",
            "phone_code": "31",
            "country_code": "NL"
        },
        {
            "id": 163,
            "name": "Norway",
            "phone_code": "47",
            "country_code": "NO"
        },
        {
            "id": 164,
            "name": "Nepal",
            "phone_code": "977",
            "country_code": "NP"
        },
        {
            "id": 165,
            "name": "Nauru",
            "phone_code": "674",
            "country_code": "NR"
        },
        {
            "id": 166,
            "name": "Niue",
            "phone_code": "683",
            "country_code": "NU"
        },
        {
            "id": 167,
            "name": "New Zealand",
            "phone_code": "64",
            "country_code": "NZ"
        },
        {
            "id": 168,
            "name": "Oman",
            "phone_code": "968",
            "country_code": "OM"
        },
        {
            "id": 169,
            "name": "Panama",
            "phone_code": "507",
            "country_code": "PA"
        },
        {
            "id": 170,
            "name": "Peru",
            "phone_code": "51",
            "country_code": "PE"
        },
        {
            "id": 171,
            "name": "French Polynesia",
            "phone_code": "689",
            "country_code": "PF"
        },
        {
            "id": 172,
            "name": "Papua New Guinea",
            "phone_code": "675",
            "country_code": "PG"
        },
        {
            "id": 173,
            "name": "Philippines",
            "phone_code": "63",
            "country_code": "PH"
        },
        {
            "id": 174,
            "name": "Pakistan",
            "phone_code": "92",
            "country_code": "PK"
        },
        {
            "id": 175,
            "name": "Poland",
            "phone_code": "48",
            "country_code": "PL"
        },
        {
            "id": 176,
            "name": "Saint Pierre and Miquelon",
            "phone_code": "508",
            "country_code": "PM"
        },
        {
            "id": 177,
            "name": "Pitcairn",
            "phone_code": "64",
            "country_code": "PN"
        },
        {
            "id": 178,
            "name": "Puerto Rico",
            "phone_code": "1-939",
            "country_code": "PR"
        },
        {
            "id": 179,
            "name": "Palestine, State of",
            "phone_code": "970",
            "country_code": "PS"
        },
        {
            "id": 180,
            "name": "Portugal",
            "phone_code": "351",
            "country_code": "PT"
        },
        {
            "id": 181,
            "name": "Palau",
            "phone_code": "680",
            "country_code": "PW"
        },
        {
            "id": 182,
            "name": "Paraguay",
            "phone_code": "595",
            "country_code": "PY"
        },
        {
            "id": 183,
            "name": "Qatar",
            "phone_code": "974",
            "country_code": "QA"
        },
        {
            "id": 184,
            "name": "Réunion",
            "phone_code": "262",
            "country_code": "RE"
        },
        {
            "id": 185,
            "name": "Romania",
            "phone_code": "40",
            "country_code": "RO"
        },
        {
            "id": 186,
            "name": "Serbia",
            "phone_code": "381",
            "country_code": "RS"
        },
        {
            "id": 187,
            "name": "Russian Federation",
            "phone_code": "7",
            "country_code": "RU"
        },
        {
            "id": 188,
            "name": "Rwanda",
            "phone_code": "250",
            "country_code": "RW"
        },
        {
            "id": 189,
            "name": "Saudi Arabia",
            "phone_code": "966",
            "country_code": "SA"
        },
        {
            "id": 190,
            "name": "Solomon Islands",
            "phone_code": "677",
            "country_code": "SB"
        },
        {
            "id": 191,
            "name": "Seychelles",
            "phone_code": "248",
            "country_code": "SC"
        },
        {
            "id": 192,
            "name": "Sudan",
            "phone_code": "249",
            "country_code": "SD"
        },
        {
            "id": 193,
            "name": "Sweden",
            "phone_code": "46",
            "country_code": "SE"
        },
        {
            "id": 194,
            "name": "Singapore",
            "phone_code": "65",
            "country_code": "SG"
        },
        {
            "id": 195,
            "name": "Saint Helena, Ascension and Tristan da Cunha",
            "phone_code": "290",
            "country_code": "SH"
        },
        {
            "id": 196,
            "name": "Slovenia",
            "phone_code": "386",
            "country_code": "SI"
        },
        {
            "id": 197,
            "name": "Svalbard and Jan Mayen",
            "phone_code": "47",
            "country_code": "SJ"
        },
        {
            "id": 198,
            "name": "Slovakia",
            "phone_code": "421",
            "country_code": "SK"
        },
        {
            "id": 199,
            "name": "Sierra Leone",
            "phone_code": "232",
            "country_code": "SL"
        },
        {
            "id": 200,
            "name": "San Marino",
            "phone_code": "378",
            "country_code": "SM"
        },
        {
            "id": 201,
            "name": "Senegal",
            "phone_code": "221",
            "country_code": "SN"
        },
        {
            "id": 202,
            "name": "Somalia",
            "phone_code": "252",
            "country_code": "SO"
        },
        {
            "id": 203,
            "name": "Suriname",
            "phone_code": "597",
            "country_code": "SR"
        },
        {
            "id": 204,
            "name": "South Sudan",
            "phone_code": "211",
            "country_code": "SS"
        },
        {
            "id": 205,
            "name": "Sao Tome and Principe",
            "phone_code": "239",
            "country_code": "ST"
        },
        {
            "id": 206,
            "name": "El Salvador",
            "phone_code": "503",
            "country_code": "SV"
        },
        {
            "id": 207,
            "name": "Sint Maarten (Dutch part)",
            "phone_code": "1-721",
            "country_code": "SX"
        },
        {
            "id": 208,
            "name": "Syrian Arab Republic",
            "phone_code": "963",
            "country_code": "SY"
        },
        {
            "id": 209,
            "name": "Eswatini",
            "phone_code": "268",
            "country_code": "SZ"
        },
        {
            "id": 210,
            "name": "Turks and Caicos Islands",
            "phone_code": "1-649",
            "country_code": "TC"
        },
        {
            "id": 211,
            "name": "Chad",
            "phone_code": "235",
            "country_code": "TD"
        },
        {
            "id": 212,
            "name": "French Southern Territories",
            "phone_code": "262",
            "country_code": "TF"
        },
        {
            "id": 213,
            "name": "Togo",
            "phone_code": "228",
            "country_code": "TG"
        },
        {
            "id": 214,
            "name": "Thailand",
            "phone_code": "66",
            "country_code": "TH"
        },
        {
            "id": 215,
            "name": "Tajikistan",
            "phone_code": "992",
            "country_code": "TJ"
        },
        {
            "id": 216,
            "name": "Tokelau",
            "phone_code": "690",
            "country_code": "TK"
        },
        {
            "id": 217,
            "name": "Timor-Leste",
            "phone_code": "670",
            "country_code": "TL"
        },
        {
            "id": 218,
            "name": "Turkmenistan",
            "phone_code": "993",
            "country_code": "TM"
        },
        {
            "id": 219,
            "name": "Tunisia",
            "phone_code": "216",
            "country_code": "TN"
        },
        {
            "id": 220,
            "name": "Tonga",
            "phone_code": "676",
            "country_code": "TO"
        },
        {
            "id": 221,
            "name": "Türkiye",
            "phone_code": "90",
            "country_code": "TR"
        },
        {
            "id": 222,
            "name": "Trinidad and Tobago",
            "phone_code": "1-868",
            "country_code": "TT"
        },
        {
            "id": 223,
            "name": "Tuvalu",
            "phone_code": "688",
            "country_code": "TV"
        },
        {
            "id": 224,
            "name": "Taiwan, Province of China",
            "phone_code": "886",
            "country_code": "TW"
        },
        {
            "id": 225,
            "name": "Tanzania, United Republic of",
            "phone_code": "255",
            "country_code": "TZ"
        },
        {
            "id": 226,
            "name": "Ukraine",
            "phone_code": "380",
            "country_code": "UA"
        },
        {
            "id": 227,
            "name": "Uganda",
            "phone_code": "256",
            "country_code": "UG"
        },
        {
            "id": 228,
            "name": "United States Minor Outlying Islands",
            "phone_code": "1",
            "country_code": "UM"
        },
        {
            "id": 229,
            "name": "United States of America",
            "phone_code": "1",
            "country_code": "US"
        },
        {
            "id": 230,
            "name": "Uruguay",
            "phone_code": "598",
            "country_code": "UY"
        },
        {
            "id": 231,
            "name": "Uzbekistan",
            "phone_code": "998",
            "country_code": "UZ"
        },
        {
            "id": 232,
            "name": "Holy See",
            "phone_code": "379",
            "country_code": "VA"
        },
        {
            "id": 233,
            "name": "Saint Vincent and the Grenadines",
            "phone_code": "1-784",
            "country_code": "VC"
        },
        {
            "id": 234,
            "name": "Venezuela (Bolivarian Republic of)",
            "phone_code": "58",
            "country_code": "VE"
        },
        {
            "id": 235,
            "name": "Virgin Islands (British)",
            "phone_code": "1-284",
            "country_code": "VG"
        },
        {
            "id": 236,
            "name": "Virgin Islands (U.S.)",
            "phone_code": "1-340",
            "country_code": "VI"
        },
        {
            "id": 237,
            "name": "Viet Nam",
            "phone_code": "84",
            "country_code": "VN"
        },
        {
            "id": 238,
            "name": "Vanuatu",
            "phone_code": "678",
            "country_code": "VU"
        },
        {
            "id": 239,
            "name": "Wallis and Futuna",
            "phone_code": "681",
            "country_code": "WF"
        },
        {
            "id": 240,
            "name": "Samoa",
            "phone_code": "685",
            "country_code": "WS"
        },
        {
            "id": 241,
            "name": "Yemen",
            "phone_code": "967",
            "country_code": "YE"
        },
        {
            "id": 242,
            "name": "Mayotte",
            "phone_code": "262",
            "country_code": "YT"
        },
        {
            "id": 243,
            "name": "South Africa",
            "phone_code": "27",
            "country_code": "ZA"
        },
        {
            "id": 244,
            "name": "Zambia",
            "phone_code": "260",
            "country_code": "ZM"
        },
        {
            "id": 245,
            "name": "Zimbabwe",
            "phone_code": "263",
            "country_code": "ZW"
        },
        {
            "id": 246,
            "name": "Guernsey",
            "phone_code": "44-1481",
            "country_code": "GG"
        },
        {
            "id": 247,
            "name": "Isle of Man",
            "phone_code": "44-1624",
            "country_code": "IM"
        },
        {
            "id": 248,
            "name": "Jersey",
            "phone_code": "44-1534",
            "country_code": "JE"
        }
    ]"""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview = findViewById<TextView>(R.id.tv_main)

        val dialog = CountryPickerDialog(this)

        textview.setOnClickListener {

            dialog.onItemSelected {
                textview.text = it.name
            }
            dialog.show()
            dialog.showPhoneCode(true)
            dialog.setDialogHeightProportion(0.9f)
//            dialog.setCountryTextColor(Color.RED)
//            dialog.setPhoneCodeTextColor(Color.BLUE)
//            dialog.setCountryTextSize(16f)
//            dialog.setCornerRadius(50f)
        }




    }

    private fun getItemsFromJsonArray(){
        val jsonArray = JSONArray(json)
        for (i in 0 until  jsonArray.length()){
            val item = "countries.add(Country(" +
                    "id=${jsonArray.getJSONObject(i).getInt("id")}," +
                    "name=\"${jsonArray.getJSONObject(i).getString("name")}\"," +
                    "phoneCode=\"${jsonArray.getJSONObject(i).getString("phone_code")}\"," +
                    "countryCode=\"${jsonArray.getJSONObject(i).getString("country_code")}\"" +
                    "))"
            Log.d("", item)

        }

    }

}