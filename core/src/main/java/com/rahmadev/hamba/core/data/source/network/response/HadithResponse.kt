package com.rahmadev.hamba.core.data.source.network.response

import com.google.gson.annotations.SerializedName

data class HadithResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("items")
	val items: List<HadithResponseItem>,
)

data class HadithResponseItem(

	@field:SerializedName("number")
	val number: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("arab")
	val arab: String? = null
)