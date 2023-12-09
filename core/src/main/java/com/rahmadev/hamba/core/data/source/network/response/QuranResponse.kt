package com.rahmadev.hamba.core.data.source.network.response

import com.google.gson.annotations.SerializedName

data class QuranResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<QuranItemResponse>,

	@field:SerializedName("message")
	val message: String? = null
)

data class QuranItemResponse(

	@field:SerializedName("jumlahAyat")
	val jumlahAyat: Int? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("tempatTurun")
	val tempatTurun: String? = null,

	@field:SerializedName("arti")
	val arti: String? = null,

	@field:SerializedName("nomor")
	val nomor: Int? = null,

	@field:SerializedName("namaLatin")
	val namaLatin: String? = null
)