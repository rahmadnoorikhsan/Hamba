package com.rahmadev.hamba.core.data.source.dummy

import com.rahmadev.hamba.core.domain.model.adzan.Adzan

object AdzansData {
    val dummyAdzan = listOf(
        Adzan(
            id = 1,
            arabic = "اَللهُ اَكْبَرُ ،اَللهُ اَكْبَر (٢x)ُِ",
            translate = "Allah Maha Besar, Allah Maha Besar"
        ),
        Adzan(
            id = 2,
            arabic = "(٢x)ِ أَشْهَدُ اَنْ لَا إِلٰهَ إِلَّااللهُ",
            translate = "Aku bersaksi bahwa Tiada Tuhan melainkan Allah."
        ),
        Adzan(
            id = 3,
            arabic = "اَشْهَدُ اَنَّ مُحَمَّدًا رَسُوْلُ الله ِ(٢x)ِ",
            translate = "Aku bersaksi bahwa Nabi Muhammad itu adalah utusan Allah."
        ),
        Adzan(
            id = 4,
            arabic = "حَيَّ عَلَى الصَّلَاة (٢x)ِ",
            translate = "Marilah menunaikan salat."
        ),
        Adzan(
            id = 5,
            arabic = "(٢x)ِ حَيَّ عَلَى الْفَلَاحِ",
            translate = "Marilah menuju kepada kejayaan."
        ),
        Adzan(
            id = 6,
            arabic = "(١x) اَللهُ اَكْبَرُ ،اَللهُ اَكْبَرُ",
            translate = "Allah Maha Besar, Allah Maha Besar"
        ),
        Adzan(
            id = 7,
            arabic = "(١x) لَا إِلَهَ إِلَّااللهُ",
            translate = "Tiada Tuhan selain Allah"
        )
    )
}