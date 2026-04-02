package com.alqiran.portfoliomain.data.mapper

import com.alqiran.portfoliomain.data.datasourses.remote.model.ContactAndAccounts
import com.alqiran.portfoliomain.ui.model.ContactAndAccountsUiModel

fun ContactAndAccountsUiModel.toContactAndAccount(): ContactAndAccounts {
    return ContactAndAccounts(
            id = this.id,
            webName = this.webName,
            url = this.url
        )
}