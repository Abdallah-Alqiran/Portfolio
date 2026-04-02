package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.ContactAndAccounts
import com.alqiran.portfoliomain.ui.model.ContactAndAccountsUiModel

fun List<ContactAndAccountsUiModel>.toContactAndAccounts(): List<ContactAndAccounts> {
    return this.map { item ->
        ContactAndAccounts(
            id = item.id,
            webName = item.webName,
            url = item.url
        )
    }
}