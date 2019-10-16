package com.github.zhangquanli.aliyun.sms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SignFile
 *
 * @author zhangquanli
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignFile {

    /**
     * 描述：签名的证明文件格式，支持上传多张图片。当前支持jpg、png、gif或jpeg格式的图片。
     * 示例：jpg
     */
    private String fileSuffix;
    /**
     * 描述：签名的资质证明文件经base64编码后的字符串。图片不超过2 MB。
     * 示例：R0lGODlhHAAmAKIHAKqqqsvLy0hISObm5vf394uLiwAA
     */
    private String fileContents;
}
