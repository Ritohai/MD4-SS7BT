<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>JSP - Hello World</title>
</head>
<body>
<div class="w-full flex flex-col items-center mt-[50px] mb-[100px]">
    <div class="font-bold text-6xl mb-16">
        <h1>Danh Sách Khách Hàng</h1>
    </div>

    <div class="w-[650px]">
        <table class="w-full">
            <thead>
            <tr class="bg-stone-600 text-white font-semi-bold text-lg h-[50px]">
                <td class="px-4">Tên</td>
                <td class="px-4">Ngày Sinh</td>
                <td class="px-4">Địa chỉ</td>
                <td class="px-4 text-center">Ảnh</td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${customers}" var="c">
                <tr class="border-b-2 border-stone-600 even:bg-zinc-100 hover:bg-zinc-200">
                    <td class="px-4">${c.name}</td>
                    <td class="px-4">${c.birthDay}</td>
                    <td class="px-4">${c.address}</td>
                    <td class="p-4 flex justify-center">
                        <img src="${c.photoUrl}" class="w-[100px] object-cover">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>