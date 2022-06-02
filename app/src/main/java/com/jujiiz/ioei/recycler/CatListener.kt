package com.jujiiz.ioei.recycler

import com.jujiiz.ioei.entity.CatEntity

interface CatListener {
    fun onSelectCat(selected: CatEntity)
}