package com.junhua.app1

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.google.gson.JsonPrimitive

fun main() {
//    testGson()
//    testGson2()
    testGson3()
}

fun testGson3() {
    val json0 = JsonObject().apply {
        addProperty("name", "Jerry")
        addProperty("age", 8)
    }
    val jsonArray = JsonArray()
    val json1 = JsonObject().apply {
        addProperty("name", "Jerry")
        addProperty("age", 8)
        add("sub", json0)
        add("array", jsonArray)
    }
    val jsonString = json1.toString()
    val json = JsonParser.parseString(jsonString).asJsonObject
//    val json = JsonParser.parseString("{show_moment_tab_plus:\"1\"}").asJsonObject
//    val json = JsonParser.parseString("{show_moment_tab_plus:[]}").asJsonObject
    val element = json.get("array")
    val content: String = element.toString()
//    val content2: String = element.asString
//    println("json, $element, content $content, content2 $content2")
    println("json, $element, content $content")
    if (element is JsonPrimitive) {
        println("jsonPrimitive, $element")
    } else if (element is JsonArray) {
        println("jsonArray, $element")
    } else if (element is JsonObject) {
        println("jsonObject, $element")
    } else {
        println("json, Else, $element")
    }
}
fun testGson2() {
    val json = JsonObject()
    json.addProperty("uid", "f001")
    json.addProperty("safety_area_1", 1)
    json.addProperty("safety_area_2", 2)
    val list = ArrayList<JsonObject>()
    list.add(json)
//    JSON.toJSONString(list).let {
//        print("JSON.toJSONString(list): $it")
//    }
    val array = JsonArray()
    array.add(json)
    println("testGson2: ${array.toString()}")
}

fun testGson() {
    val json = com.google.gson.JsonObject()
    json.addProperty("bool", 1)
    json.addProperty("age", 8)
    json.addProperty("name", "Jerry")
    json.addProperty("height", 100L)
    val subJson = com.google.gson.JsonObject()
    subJson.addProperty("sub_age", 10)
    json.add("sub", subJson)
    println("#testGsonJson, json(toString) ${json.toString()}")

//    val json = com.google.gson.JsonParser.parseString("{\"name\":\"Jerry\",\"age\":8,\"height\":1.33}").asJsonObject
//    println("#testGsonJson, parsed json(toString) ${json.toString()}")

    // wrong
//    println("#testGsonJson, json(getAsString) ${json.asString}")
//    if (json.has("hi")) {
//        val element = json.get("hi")
//        val asInt = element.asInt
//        println("#testGsonJson, getAsInt(hi) $asInt")
//    } else {
//        println("#testGsonJson, getAsInt(hi), no this element!")
//    }
//    val asJsonArray = json.getAsJsonArray("array")
//    println("#testGsonJson, asJsonArray $asJsonArray")
//    val asJsonArray2 = json.get("array").asJsonArray
//    println("#testGsonJson, asJsonArray2 $asJsonArray2")
//    val jsonObject = json.getAsJsonObject("obj")
//    println("#testGsonJson, asJsonObject $jsonObject")
////    val jsonObject2 = json.get("obj").asJsonObject
////    println("#testGsonJson, asJsonObject2 $jsonObject2")
//    // java.lang.UnsupportedOperationException: JsonObject
//    val asString = json.get("name").asString
//    println("#testGsonJson, json.asString $asString")

//    val age = json.getInt("age")
//    println("#testGsonJson, json.getInt(age) $age")

    val isBool = json.get("bool").asBoolean
    println("#testGsonJson, json.getBoolean(bool) $isBool")
}

fun JsonObject.getInt(key: String, defaultValue: Int = -1): Int {
//    val result: Int? = try {
//        this.get(key)?.takeIf {
//            it.isJsonPrimitive
//        }?.print()?.asJsonPrimitive?.asInt
//    } catch (e: NumberFormatException) {
//        println(e)
//        defaultValue
//    }
//    return result ?: defaultValue

    return try {
        this.get(key)?.takeIf {
            it.isJsonPrimitive
        }?.asJsonPrimitive?.asInt
            ?: defaultValue
    } catch (e: NumberFormatException) {
        defaultValue
    }
}

fun JsonElement.print(): JsonElement {
    println("JsonObject#print")
    return this
}