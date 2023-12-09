package com.rahmadev.hamba.core.data.source.network.response

import com.google.gson.annotations.SerializedName

data class DoaResponseItem(

	@field:SerializedName("terjemah")
	val terjemah: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("latin")
	val latin: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("arab")
	val arab: String? = null
)
