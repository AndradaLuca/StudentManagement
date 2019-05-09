//
//  Constants.swift
//  StudentManagement
//
//  Created by Radu Tothazan on 08/05/2019.
//  Copyright © 2019 radu. All rights reserved.
//

import Foundation
import UIKit

var baseUrl: String {
    return "http://172.20.10.2:8080"
}

//MARK: User Defaults keys
let tokenKey = "token"

let loginNavigationId = "loginNavigation"
let mainTabBarId = "mainTabBar"

extension UIColor {
    
    open class var mainColor: UIColor {
        return UIColor(red: 34/255, green: 67/255, blue: 210/255, alpha: 1)
    }
}
